package org.apache.beam.util;

import com.google.cloud.spanner.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicSchemaMapping {
  private static final Logger LOG = LoggerFactory.getLogger(DynamicSchemaMapping.class);

  private static Spanner spanner;
  private static Map<String, Map<String, Map<String, String>>> tableSchemaMapping = new HashMap<>();
  private static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern(
          "yyyy-MM-dd HH:mm:ss"); // Changed to thread-safe DateTimeFormatter

  static {
    SpannerOptions options = SpannerOptions.newBuilder().build();
    spanner = options.getService();
  }

  private synchronized static Map<String, Map<String, String>> getColumnMapping(String tableName) {
    // Ensure this is called only once for the very first time as this method requires to connect to
    // spanner database.
    if (tableSchemaMapping.containsKey(tableName)) {
      return tableSchemaMapping.get(tableName);
    }
    Map<String, Map<String, String>> columnMapping = new HashMap<>();
    tableSchemaMapping.put(tableName, columnMapping);
    LOG.info("Fetching database schema");
    // Spanner instance and database IDs
    String projectid = "ggspandf";
    String instanceId = "spanner1";
    String databaseId = "rxc";
    DatabaseId db = DatabaseId.of(projectid, instanceId, databaseId);
    DatabaseClient dbClient = spanner.getDatabaseClient(db);

    // Construct the query dynamically
    String sql =
        "SELECT column_name, data_type FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"
            + tableName
            + "' order by ordinal_position";

    try (ResultSet resultSet = dbClient.singleUse().executeQuery(Statement.of(sql))) {
      while (resultSet.next()) {
        Map<String, String> columnInfo = new HashMap<>();
        String columnName = resultSet.getString("column_name");
        String dataType = resultSet.getString("data_type");
        columnInfo.put("column_name", columnName);
        columnInfo.put("data_type", dataType);
        columnMapping.put(columnName.toLowerCase(), columnInfo);
        LOG.info(columnName.toLowerCase() + ": " + columnInfo);
      }
    }
    tableSchemaMapping.put(tableName, columnMapping);

    return columnMapping;
  }

  public static com.google.cloud.Timestamp convertTimestamp(java.util.Date date) {
    if (date == null) return null;
    return com.google.cloud.Timestamp.of(date);
  }

  public static com.google.cloud.Timestamp convertTimestamp(String date) {
    // Parse the string into a LocalDateTime object
    LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
    Instant instant = localDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
    Date converteddate = Date.from(instant);

    return com.google.cloud.Timestamp.of(converteddate);
  }

  public static Mutation.WriteBuilder buildMutationFromMapping(
      Mutation.WriteBuilder mutationBuilder, JSONObject jsonObject, String table_name) {

    // Get column names for the provided table name
    Map<String, Map<String, String>> columnMapping = getColumnMapping(table_name);

    for (Map.Entry<String, Map<String, String>> entry : columnMapping.entrySet()) {
      Map<String, String> columnInfo = entry.getValue();
      String spannerColumnName = columnInfo.get("column_name");
      String dataType = columnInfo.get("data_type");
      if (jsonObject.has(spannerColumnName.toUpperCase())) {
        switch (dataType) {
          case "character varying":
            if (jsonObject.isNull(spannerColumnName.toUpperCase())) {
              mutationBuilder.set(spannerColumnName.toLowerCase()).to((String) null);
            } else {
              mutationBuilder
                  .set(spannerColumnName.toLowerCase())
                  .to(jsonObject.getString(spannerColumnName.toUpperCase()));
            }

            break;
          case "bigint":
            if (jsonObject.isNull(spannerColumnName.toUpperCase())) {
              mutationBuilder.set(spannerColumnName.toLowerCase()).to((Long) null);
            } else {
              mutationBuilder
                  .set(spannerColumnName.toLowerCase())
                  .to(jsonObject.getLong(spannerColumnName.toUpperCase()));
            }

            break;
          case "double precision":
            if (jsonObject.isNull(spannerColumnName.toUpperCase())) {
              mutationBuilder.set(spannerColumnName.toLowerCase()).to((Double) null);
            } else {
              mutationBuilder
                  .set(spannerColumnName.toLowerCase())
                  .to(jsonObject.getDouble(spannerColumnName.toUpperCase()));
            }

            break;
          case "timestamp with time zone":
            if (jsonObject.isNull(spannerColumnName.toUpperCase())) {
              mutationBuilder
                  .set(spannerColumnName.toLowerCase())
                  .to((com.google.cloud.Timestamp) null);
            } else {
              String date = jsonObject.getString(spannerColumnName.toUpperCase());
              mutationBuilder.set(spannerColumnName.toLowerCase()).to(convertTimestamp(date));
            }

            break;
          default:
            LOG.error("Unsupported data type: " + dataType + " for column: " + spannerColumnName);
        }
      } else {
        LOG.info(spannerColumnName.toUpperCase() + " is missing from on json Object");
      }
    }

    return mutationBuilder;
  }
}
