FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add /bin/sh

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY *.jar $PROJECT_HOME/*.jar

WORKDIR $PROJECT_HOME

CMD ["java" ,"-jar","./*.jar"]
