### Feign - used for Load Balancing
- load balancer framework is used by feign to distribute the load among the multiple instances which are returned by Eureka

------------------------------------------------------------------------------------------------------------------------
### Circuit Breaker

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
### Watch
- run Windows PowerShell as Administrator
- Set-ExecutionPolicy -ExecutionPolicy Unrestricted
- Import-Module -Name 'Watch'

------------------------------------------------------------------------------------------------------------------------


### Docker

    `<build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <configuration>
                        <image>
                            <name>kvandana/${project.artifactId}:${project.version}</name>
                        </image>
                        <pullPolicy>IF_NOT_PRESENT</pullPolicy>
                    </configuration>
                </plugin>
            </plugins>
        </build>`

------------------------------------------------------------------------------------------------------------------------
### Container Orchestration

#### Why? :
- Manages 1000's of instances, 1000's of microservices 
- it is cloud Neutral, Standardized platform on my cloud infrastructure

#### Typical Features
- Auto Scaling - Scale containers based on demand (if Microservices A has a lot of
  load then I may want to have multiple instances based on the load that is coming in, so I want autoscaling)
- Service Discovery - Help Microservices find another one
- Load Balancing - Distribute load among multiple instances of a Microservices
- Self Healing - Do health checks and replace failing instances (if one instance is down, container Orchestration tool
  should be able to identify that and automatically launch a new instance)
- Zero Downtime Deployments - Release new versions without downtime

#### Container Orchestration Options

- AWS Specific
  - AWS Elastic Container Service (ECS)
  - AWS Fargate: Serverless version of AWS ECS
- Cloud Neutral - Kubernetes
  - AWS Elastic Container Service (ECS)  
  - Azure - Azure Kubernetes Service (AKS)
  - GCP - Google Kubernetes Engine (GKS)
  - EKS/AKS does not have a free tier! - we use GCP and GKE

### Why Docker ?

- Standardized Application Packaging :  same packaging for all applications
- Features :
  - language Neutral
  - Cloud Neutral
  - Enables Standardization
- Challenges
  - 1000 microservices
    - 1000 instances

#### Clusters
- Cluster is nothing but a combination of Nodes and Master Node
- the nodes that run the application are called Worker Node
- the node that manages the nodes are called Master Node

#### Pods
- pod is the smallest deployable unit in kubernetes
- A pod is a collection of containers that can run on a host. This resource is created by clients and scheduled onto hosts.
- you cannot have a container without a pod, container lives inside a pod and each pod can have multiple containers
- each pod has a unique ip address
- kubectl explain pods
- kubectl get pods -o wide
- kubectl kubectl describe pod 'id of the pod'
- 
------------------------------------------------------------------------------------------------------------------------
## https://cloud.google.com/
- create an Account
- go to MY First Project
- Search for Kubernetes Engine

- create a cluster
- connect to K8S cluster using Google Cloud Shell
  - go to the cluster > and activate the cloud shell
  - click on "Connect" and get the command
  - example :  gcloud container clusters get-credentials gc-kvandana --zone us-central1-c --project peak-tract-337209
  
- kubectl version (Server Version is the cluster we are connecting our kubectl to )

- deploy an application to kubectl cluster
  - kubectl create deployment currency-exchange-service --image=kvandana/currency-exchange-service:0.0.1-SNAPSHOT
- Expose it to the outside world
  - kubectl expose deployment currency-exchange-service --type=LoadBalancer --port=8000
  
- Check for the creation : go to Services & Ingress
- click on the Endpoints and add '/currency-exchange/from/USD/to/INR'
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
### 
- K8S stands for Kubernetes (pronounce - koo ber net eez)
- Kubectl stands for Kube Controller (pronounce - cube cuttle)
------------------------------------------------------------------------------------------------------------------------
### SET-up

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
#### Change Port on a Spring Boot Application when using intelliJ
- https://codedevstuff.blogspot.com/2015/05/change-port-on-spring-boot-application.html
- Create multiple instances for currency-exchange-service
  - server port 8000, 8001