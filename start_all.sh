cd ../kafka/
./bin/zookeeper-server-start.sh config/zookeeper.properties &
cd ../kafka/
./bin/kafka-server-start.sh config/server.properties &
cd ../kafka/
./bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic news --replication-factor 1 --partitions 1