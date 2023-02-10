cd ~/confluent/ &&
./bin/zookeeper-server-start etc/kafka/zookeeper.properties &
cd ~/confluent/ &&
./bin/kafka-server-start etc/kafka/server.properties &
cd ~/confluent/ &&
./bin/kafka-server-start etc/kafka/server-one.properties &
cd ~/confluent/ &&
./bin/schema-registry-start etc/schema-registry/schema-registry.properties &
