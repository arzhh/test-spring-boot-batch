# test-spring-boot-batch
Small test of Spring batch with spring boot, compile and run with maven
## Installation
Use this command to generate the JAR file :
`mvn clean install`
## Run
Use this command to run the batch (note : you need to configure SQL server and change the file application.properties) :
`mvn spring-boot:run -Dspring-boot.run.arguments=--value=testValue`
