# URL and Response Structure for Currency Exchange Service

### URL
http://localhost:8000/currency-exchange/from/USD/to/INR

### Response Structure
{
"id":10001,
"from":"USD",
"to":"INR",
"conversionMultiple":65.00,
"environment":"8000 instance-id"
}
------------------------------------------------------------------------------------------------------------------------
### Change Port on a Spring Boot Application when using intelliJ
- https://codedevstuff.blogspot.com/2015/05/change-port-on-spring-boot-application.html 
------------------------------------------------------------------------------------------------------------------------
Spring Initializr - Setting up currency-exchange-service
- https://start.spring.io/
    - Project : Maven
    - Language : Java
    - Spring Boot : 2.6.2
    - Group : com.kaur.vandana.microservices
    - Artifacts : currency-exchange-service
    - Description : currency-exchange-service
    - Dependencies : Spring Boot DevTools, Spring Boot Actuator, Spring Web, Config Client
------------------------------------------------------------------------------------------------------------------------
Spring Initializr - Setting up currency-conversation-service
- https://start.spring.io/
  - Project : Maven
  - Language : Java
  - Spring Boot : 2.6.2
  - Group : com.kaur.vandana.microservices
  - Artifacts : currency-conversation-service
  - Description : Demo project for microservices
  - Dependencies : Spring Boot DevTools, Spring Boot Actuator, Spring Web, Config Client 
------------------------------------------------------------------------------------------------------------------------

Spring Initializr - Setting up Naming Server [Service Registry]
- https://start.spring.io/
  - Project : Maven
  - Language : Java
  - Spring Boot : 2.6.2
  - Group : com.kaur.vandana.microservices
  - Artifacts : naming-server
  - Description : Demo project for microservices
  - Dependencies : Spring Boot DevTools, Spring Boot Actuator, Eureka Server

------------------------------------------------------------------------------------------------------------------------

## To DO
- SET port 8001 for currency-exchange-service
