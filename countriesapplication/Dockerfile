FROM maven:3.8.4-jdk-8
COPY src /countriesapplication/src
COPY pom.xml /countriesapplication
WORKDIR countriesapplication
RUN mvn clean package