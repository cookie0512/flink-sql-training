FROM maven:3.6-jdk-8-slim

COPY ./conf/settings.xml /usr/share/maven/conf/

COPY ./java-project /project
RUN cd /project; \
    mvn clean package

WORKDIR /project/target

ENTRYPOINT [ "java", "-cp", "kafka-producer-1.0-SNAPSHOT.jar", "com.xxywebsite.MyKafkaProducer" ]