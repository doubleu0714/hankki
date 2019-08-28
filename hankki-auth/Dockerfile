FROM openjdk:8-jre

RUN mkdir /hakki-auth

EXPOSE 8080

WORKDIR /hakki-auth

COPY Dockerfile .
COPY target/*.jar /hakki-auth

CMD java -Djava.security.egd=file:/dev/./urandom -jar *.jar 