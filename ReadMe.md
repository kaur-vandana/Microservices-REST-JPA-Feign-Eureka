- Build an Amazing REST API with Spring Boot
- Build Microservices with Spring Boot and Spring Cloud
- Build Containers with Docker
- orchestrate Microservices with Kubernetes

------------------------------------------------------------------------------------------------------------------------
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
# Docker

- Download and Install
  - https://docs.docker.com/desktop/windows/install/

- docker --version
- docker run -p 9411:9411 openzipkin/zipkin:2.23
  - http://localhost:9411/zipkin/ 
- Connect Microservices to Zipkin

- Images
  - https://hub.docker.com/u/
- Currency Exchange Service 
  - 
- Currency Conversion Service
  - 
------------------------------------------------------------------------------------------------------------------------

## Eureka
- 

------------------------------------------------------------------------------------------------------------------------

## API GATEWAY
- 

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

# Commands
- docker run -p 9411:9411 openzipkin/zipkin:2.23
- docker push 
- docker-compose --version
- docker-compose up
- docker push 
- docker push 
- docker push 
- watch -n 0.1 curl http://localhost:8000/sample-api
------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------



