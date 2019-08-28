FROM openjdk:8-jre

RUN mkdir /hakki-material

EXPOSE 8081

WORKDIR /hakki-material

COPY Dockerfile .
COPY target/*.jar /hakki-material

CMD java -Djava.security.egd=file:/dev/./urandom -jar *.jar 