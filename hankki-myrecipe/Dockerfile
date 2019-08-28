FROM openjdk:8-jre

RUN mkdir /hakki-myrecipe

EXPOSE 8082

WORKDIR /hakki-myrecipe

COPY Dockerfile .
COPY target/*.jar /hakki-myrecipe

CMD java -Djava.security.egd=file:/dev/./urandom -jar *.jar 