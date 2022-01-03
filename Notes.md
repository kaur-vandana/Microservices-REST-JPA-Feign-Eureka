## Feign - used for Load Balancing
- load balancer framework is used by feign to distribute the load among the multiple instances which are returned by Eureka
------------------------------------------------------------------------------------------------------------------------
## Circuit Breaker

Miroservice1 -> Miroservice2 -> Miroservice3 -> Miroservice4 -> Miroservice5

- what if one of the service is down or slow?
  - Impacts entire chain!
  
#### Questions
- Can we return a fallback response if a service is down?
  - fallback response : when the service is down for a small period of time
  
- Can we implement a Circuit Breaker pattern to reduce load?
- Can we retry requests in case of temporary failures?
- Can we implement rate limiting?

#### Solution
- Circuit Beaker Framework - Resilience4j

------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
# SET-up
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
Spring Initializr - Setting up API Gateway
- https://start.spring.io/
  - Project : Maven
  - Language : Java
  - Spring Boot : 2.6.2
  - Group : com.kaur.vandana.microservices
  - Artifacts : api-gateway
  - Description : Demo project for microservices
  - Dependencies : Spring Boot DevTools, Spring Boot Actuator, Eureka Discovery Client, Gateway
------------------------------------------------------------------------------------------------------------------------

#### To DO
### Change Port on a Spring Boot Application when using intelliJ
- https://codedevstuff.blogspot.com/2015/05/change-port-on-spring-boot-application.html
- Create multiple instances for currency-exchange-service
  - server port 8000, 8001
------------------------------------------------------------------------------------------------------------------------

# Circuit beaker

currency-exchange-service - pom.xml

        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>
		<dependency>
			<groupId>io.github.resilience4j</groupId>
			<artifactId>resilience4j-spring-boot2</artifactId>
			<version>1.7.1</version>
		</dependency>

------------------------------------------------------------------------------------------------------------------------
# Watch
- run Windows PowerShell as Administrator
- Set-ExecutionPolicy -ExecutionPolicy Unrestricted
- Import-Module -Name 'Watch'

------------------------------------------------------------------------------------------------------------------------