package org.apache.beam.util;

import com.google.cloud.spanner.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.icu.text.SimpleDateFormat;
import org.apache.beam.examples.pojo.Prescription;
import org.apache.beam.sdk.metrics.Counter;
import org.apache.beam.sdk.metrics.Metrics;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.TupleTag;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.*;

public class dynamicSchemaMapping {

    private Spanner spanner;
    private Map<String, Map<String, String>> table1ColumnMapping;
    private Map<String, Map<String, String>> table2ColumnMapping;

    @Setup
    public void setup() {

        // Initialize Spanner client
        SpannerOptions options = SpannerOptions.newBuilder().build();
        spanner = options.getService();

        // Replace with your actual Spanner instance and database IDs
        String projectid = "ggspandf";
        String instanceId = "spanner1";
        String databaseId = "rxc";
        DatabaseId db = DatabaseId.of(projectid, instanceId, databaseId);
        DatabaseClient dbClient = spanner.getDatabaseClient(db);

        // Get column names for "prescriptionfill_uc2_first" table
        table1ColumnMapping = getColumnMapping(dbClient, "prescriptionfill_uc2_first");

        // Get column names for "prescriptionfill_uc2_second" table
        table2ColumnMapping = getColumnMapping(dbClient, "prescriptionfill_uc2_second");
    }

    private Map<String, Map<String, String>> getColumnMapping(DatabaseClient dbClient, String tableName) {
        Map<String, Map<String, String>> columnMapping = new HashMap<>();

        // Construct the query dynamically
        String sql = "SELECT column_name, data_type FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + tableName + "' order by ordinal_position";

        try (ResultSet resultSet = dbClient.singleUse().executeQuery(Statement.of(sql))) {
            while (resultSet.next()) {
                Map<String, String> columnInfo = new HashMap<>();
                String columnName = resultSet.getString("column_name");
                String dataType = resultSet.getString("data_type");
                columnInfo.put("column_name", columnName);
                columnInfo.put("data_type", dataType);
                columnMapping.put(columnName.toLowerCase(), columnInfo);
            }
        }
        return columnMapping;
    }
}
