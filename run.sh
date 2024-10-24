mvn compile exec:java -Dexec.mainClass=org.apache.beam.examples.GgTrailToSpanner \
    -Dexec.args="--runner=DataflowRunner --project=ggspandf \
                 --stagingLocation=gs://ggspandf-df/staging2 \
                 --tempLocation=gs://ggspandf-df/tmp \
                 --region=us-east4 \
                 --gcpTempLocation=gs://ggspandf-df/tmp2 \
                 --usePublicIps=false \
                 --maxNumWorkers=15 \
                 --numWorkers=3 \
                 --experiments=num_pubsub_keys=5000 \
                 --dataflowServiceOptions=enable_streaming_engine_resource_based_billing \
                 --unboundedReaderMaxReadTimeMs=1000 \
                 --enableStreamingEngine \
                 --workerMachineType=n2d-highcpu-4 \
                 --subscriptionsName=projects/ggspandf/subscriptions/RXOWNER.RXP_PRESCRIPTION_FILL-sub \
                 --subnetwork=regions/us-east4/subnetworks/private" \
    -Pdataflow-runner
                
#projects/ggspandf/subscriptions/RXOWNER.RXP_PRESCRIPTION_FILL-sub
# mvn compile exec:java -Dexec.mainClass=org.apache.beam.examples.GgTrailToSpanner \
#     -Dexec.args=" --subscriptionsName=projects/ggspandf/subscriptions/ihaffa-test-sub" \
#     -Pdirect-runner
