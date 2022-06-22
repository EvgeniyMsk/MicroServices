FROM maven:3.8.4-jdk-8
COPY src /covidapplication/src
COPY pom.xml /covidapplication
WORKDIR covidapplication
RUN mvn clean package