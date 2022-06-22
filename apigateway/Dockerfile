FROM maven:3.8.4-jdk-8
COPY src /apigateway/src
COPY pom.xml /apigateway
WORKDIR apigateway
RUN mvn clean package