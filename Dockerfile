FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/PIP-1.0-SNAPSHOT.jar /app

CMD ["java", "-jar", "PIP-1.0-SNAPSHOT.jar"]