FROM maven:3.6-jdk-8-slim

COPY ./conf/settings.xml /usr/share/maven/conf/

COPY ./project /project
RUN cd /project; \
    mvn clean install

