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
[reference]
- https://github.com/in28minutes/spring-microservices-v2
------------------------------------------------------------------------------------------------------------------------