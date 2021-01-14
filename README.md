# Table of Content
1. [Introduction](#introduction)
2. [JDK](#jdk)
3. [Maven](#maven)


## Dropwizard Demo Project <a name="introduction"></a>
Build Dropwizard Application Template with Maven which is suggested by the [official](https://www.dropwizard.io/en/latest/getting-started.html#setting-up-using-maven).

## JDK <a name="jdk"></a>
Support to use JDK 11.
> adoptopenjdk 11

## Maven <a name="maven"></a>
Better to use maven 3.3+. 
> mvn -v
> Apache Maven 3.6.3

## Build & Running
Clean & Build
> mvn clean package

Running
> mvn exec:java

Debug
> mvnDebug exec:java

Testing
http://localhost:8080/hello
