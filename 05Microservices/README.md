Microservices
----------------------------------------------------------------------------------

    Service Oriented Approach - Monolithic
    -------------------------------
        SOAP Services + ClientApp (MVC Web/SPA App/Andirod App)
        REST Services + ClientApp (MVC Web/SPA App/Andirod App)

    Service Oriented Approach - Microservices
    -------------------------------
        [REST Service1 + REST Service2 + REST Service3...]  + ClientApp (MVC Web/SPA App/Andirod App)

        1. Decomposition
        2. Distrubuted Tracing (Debugging)
        3. Routing - API Gateway
        4. Descoverability - Discovery Service
        5. Fault Tolerence - Circuit Breaking

        Step1: Interservice Communciation through RestTemplate
                LoanTypeMicroservice  
                LaonMicroservice        that consume LonaTypeMicroserice using
                                        RestTemplate

        Step2: Client Side Load Balancing using Ribbon
                LoanTypeMicroservice  
                        execute multiple instances of LoanTypeMicroservice  

                LaonMicroservice        that consume LonaTypeMicroserice using
                                        FeignClient
                                        Ribbon for Client Side Load Balancing

        Step3: Discovery Service Pattern
                LoanTypeMicroservice    Eureka Client
                LaonMicroservice        Eureka Client
                LMSDiscoveryService     using Eureka DiscoveryService

        Step4: API Gateway Pattern and circuit breaking using Hystrex
                LoanTypeMicroservice    
                LaonMicroservice        
                LMSDiscoveryService    
                LMSGatewayService       API Gateway using Zuul + Hystrex
                                        Circuit Breaking using Hystrex

        Step5: External configuaration
                LoanTypeMicroservice  
                LaonMicroservice   
                LMSDiscoveryService
                LMSGatewayService     
                LMSConfigService        Git Repo based External Configuaration 

        Step6: Distributed Tracing and Log Aggregation
                LoanTypeMicroservice  
                LaonMicroservice   
                LMSDiscoveryService
                LMSGatewayService     
                LMSConfigService    

                        Config Spring Actuator, Sleuth and Zipkin Server.
                        
                        java -jar zipkin-server-1.30.3-exec.jar
                        http://localhost:9411/zipkin/

                        <dependency>
                         <groupId>org.springframework.cloud</groupId>
                         <artifactId>spring-cloud-starter-zipkin</artifactId>
                        </dependency>
                        <dependency>
                         <groupId>org.springframework.cloud</groupId>
                         <artifactId>spring-cloud-starter-sleuth</artifactId>
                        </dependency>
