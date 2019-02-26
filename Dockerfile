FROM openjdk:8-jre-alpine
RUN mkdir /app
COPY build/libs/exercise.jar /app
WORKDIR /app
ENTRYPOINT exec java -jar exercise.jar