FROM openjdk:8-jre-alpine
RUN mkdir /app
COPY build/libs/exercice.jar /app
WORKDIR /app
ENTRYPOINT exec java -jar exercice.jar