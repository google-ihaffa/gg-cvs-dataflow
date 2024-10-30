mvn compile exec:java -Dexec.mainClass=org.apache.beam.examples.GgTrailToSpannerOneToOne \
    -Dexec.args="--runner=DataflowRunner --project=ggspandf \
                 --stagingLocation=gs://ggspandf-df/staging2 \
                 --tempLocation=gs://ggspandf-df/tmp \
                 --region=us-east4 \
                 --gcpTempLocation=gs://ggspandf-df/tmp2 \
                 --usePublicIps=false \
                 --maxNumWorkers=15 \
                 --numWorkers=4 \
                 --experiments=num_pubsub_keys=5000 \
                 --unboundedReaderMaxReadTimeMs=1000 \
                 --workerMachineType=n2d-highcpu-4 \
                 --dataflowServiceOptions=enable_streaming_engine_resource_based_billing \
                 --enableStreamingEngine \
                 --subscriptionsName=projects/ggspandf/subscriptions/order-by-time-or-pos-sub \
                 --subnetwork=regions/us-east4/subnetworks/private" \
    -Pdataflow-runner
                
# mvn compile exec:java -Dexec.mainClass=org.apache.beam.examples.GgTrailToSpannerOneToOne \
#     -Dexec.args=" --subscriptionsName=projects/ggspandf/subscriptions/ihaffa-test-sub" \
#     -Pdirect-runner


# update pid: 1, value: 1
# update pid: 1, value: 10
