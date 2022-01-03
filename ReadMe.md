- REST API with Spring Boot
- Microservices with Spring Boot and Spring Cloud
- Containers with Docker
- orchestrate Microservices with Kubernetes

- Spring Boot 2.4.x+ & Spring Cloud 2020.x+
- Service Registry using Eureka Naming Server
- Load Balancing with Spring Cloud LoadBalancer (replacing Ribbon)
- API Gateway with Spring Cloud Gateway (instead of Zuul)
- Circuit Breaker with Resilience4j (instead of Hystrix)
- Distributed Tracing with Zipkin
- Asynchronous Communication using Rabbit MQ

------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
# Docker

- Download and Install
  - https://docs.docker.com/desktop/windows/install/

- docker --version
- docker run -p 9411:9411 openzipkin/zipkin:2.23
  - http://localhost:9411/zipkin/ 
- Connect Microservices to Zipkin

- #### Images
  - https://hub.docker.com/u/kvandana
  
  - Currency Exchange Service 
    - image 'docker.io/kvandana/currency-exchange-service:0.0.1-SNAPSHOT'
  - Currency Conversion Service
    - image 'docker.io/kvandana/currency-conversation-service:0.0.1-SNAPSHOT'
  - Naming-server
    - image 'docker.io/kvandana/naming-server:0.0.1-SNAPSHOT'
------------------------------------------------------------------------------------------------------------------------
## Eureka
- http://localhost:8761/Eureka
------------------------------------------------------------------------------------------------------------------------
## API GATEWAY
- http://localhost:8765/currency-exchange/from/USD/to/INR
- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
------------------------------------------------------------------------------------------------------------------------
# URLS

- Currency Exchange Service
  - http://localhost:8000/currency-exchange/from/USD/to/INR
- Currency Conversion Service
  - http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
  - http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
- Eureka
  - http://localhost:8761/
- Zipkin
  - http://localhost:9411/
- API GATEWAY
  - http://localhost:8765/currency-exchange/from/USD/to/INR
  - http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10
  - http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
  - http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10

------------------------------------------------------------------------------------------------------------------------

# COMMANDS [Window Powershell/ Docker Desktop]
- docker run -p 9411:9411 openzipkin/zipkin:2.23

add image config to pom 
- Download and Install Maven (Path variables - Maven, M2_HOME)
  - mvn spring-boot:build-image -DskipTests
  
  - Images (829ff545d81f): 'docker.io/kvandana/currency-exchange-service:0.0.1-SNAPSHOT'
  - Images (07bf2f49bd28): 'docker.io/kvandana/naming-server:0.0.1-SNAPSHOT'
  - Images (1903d2bb6b61): 'docker.io/kvandana/currency-conversion-service:0.0.1-SNAPSHOT'
  - Images (9e65226baa6d): 'docker.io/kvandana/api-gateway:0.0.1-SNAPSHOT'


- docker run -p 8000:8000 kvandana/currency-exchange-service:0.0.1-SNAPSHOT
- docker run -p 8001:8000 kvandana/currency-exchange-service:0.0.1-SNAPSHOT
- docker run -p 8761:8761 kvandana/naming-server:0.0.1-SNAPSHOT
- docker run -p 8100:8100 kvandana/currency-conversion-service:0.0.1-SNAPSHOT

- docker-compose --version
- - cd /Microservices-REST-JPA-Feign-Eureka
- docker-compose up

- docker push docker.io/kvandana/currency-exchange-service:0.0.1-SNAPSHOT
- docker push docker.io/kvandana/naming-server:0.0.1-SNAPSHOT
- docker push docker.io/kvandana/currency-conversion-service:0.0.1-SNAPSHOT
- docker push docker.io/kvandana/api-gateway:0.0.1-SNAPSHOT

- watch -n 0.1 curl http://localhost:8000/sample-api

- to remove an image : docker rmi -f fc04a54317b4
------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------



