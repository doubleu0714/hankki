FROM openjdk:8-jre

RUN mkdir /hakki-recipe

EXPOSE 8083

WORKDIR /hakki-recipe

COPY Dockerfile .
COPY target/*.jar /hakki-recipe

CMD java -Djava.security.egd=file:/dev/./urandom -jar *.jar 