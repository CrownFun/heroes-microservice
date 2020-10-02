FROM openjdk:11.0.7-jdk-buster
ADD target/heroes-microservice-0.0.1-SNAPSHOT.jar .
EXPOSE 8761
CMD java -jar heroes-microservice-0.0.1-SNAPSHOT.jar