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

        Step2: Interservice Communciation through FeignClient
                LoanTypeMicroservice  
                        execute multiple instances of LoanTypeMicroservice  

                LaonMicroservice        that consume LonaTypeMicroserice using
                                        FeignClient
                                        Ribbon for Load Balancing
