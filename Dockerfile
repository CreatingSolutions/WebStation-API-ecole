FROM openjdk:8-jdk-alpine
COPY ./target/ecole-1.0-SNAPSHOT.jar /tmp
WORKDIR /tmp
EXPOSE 8080
CMD ["java", "-jar", "ecole-1.0-SNAPSHOT.jar"]
