FROM maven:3.8.4-jdk-8
COPY src /aggregatorapplication/src
COPY pom.xml /aggregatorapplication
WORKDIR aggregatorapplication
RUN mvn clean package