# Table of Content
1. [Introduction](#introduction)
2. [JDK](#jdk)
3. [Maven](#maven)
4. [Build&Running](#building)
5. [Swagger](#swagger)


## Dropwizard Demo Project <a name="introduction"></a>
Build Dropwizard Application Template with Maven which is suggested by the [official](https://www.dropwizard.io/en/latest/getting-started.html#setting-up-using-maven).

## JDK <a name="jdk"></a>
Support to use JDK 11.
> adoptopenjdk 11

## Maven <a name="maven"></a>
Better to use maven 3.3+. 
> mvn -v
> Apache Maven 3.6.3

## Build & Running <a name="building"></a>
Clean & Build
> mvn clean package

Running
> mvn exec:java
OR
> java -Dapplication.name=dropwizardDemo -Dapplication.home=. -Dapplication.environment=dev  -jar target/dropwizardDemo-1.0-SNAPSHOT.jar server target/classes/config/dev.yml 

Debug
> mvnDebug exec:java

Testing
> http://localhost:8080/hello

## Swagger  <a name="swagger"></a>
> http://localhost:8080/swagger
