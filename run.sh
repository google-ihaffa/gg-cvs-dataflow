mvn compile exec:java -Dexec.mainClass=org.apache.beam.examples.GgTrailToSpanner \
    -Dexec.args="--runner=DataflowRunner --project=ggspandf \
                 --region=us-east4 \
                 --gcpTempLocation=gs://ggspandf-df/tmp \
                 --usePublicIps=false \
                 --maxNumWorkers=5 \
                 --enableStreamingEngine \
                 --workerMachineType=n2d-highcpu-8 \
                 --subscriptionsName=projects/ggspandf/subscriptions/RXOWNER.RXP_PRESCRIPTION_FILL-sub \
                 --subnetwork=regions/us-east4/subnetworks/private" \
    -Pdataflow-runner
#                 --numberOfWorkerHarnessThreads=500000 \

# mvn compile exec:java -Dexec.mainClass=org.apache.beam.examples.GgTrailToSpanner \
#     -Dexec.args=" --subscriptionsName=projects/ggspandf/subscriptions/ihaffa-test-sub" \
#     -Pdirect-runner