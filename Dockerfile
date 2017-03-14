FROM java:8
EXPOSE 8080
ADD /target/SozonovRomanSpringMongoDB.jar SozonovRomanSpringMongoDB.jar
ENTRYPOINT ["java","-jar","SozonovRomanSpringMongoDB.jar"]