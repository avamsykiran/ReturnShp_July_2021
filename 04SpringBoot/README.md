Spring Boot
------------------------------------------------------------------

  Lab Setup
      JDK 1.8 and /or JDK11
      Chrome
      STS latest

  RAD Module for Spring Framework

    Rapid Application Development.


  Spring Web          Web Layer

          1. Config DispatcherServlet and its path
          2. Choose InternalResourceViewResolver
          3. Config static files like .css,.js,images ..etc out of the controller
          4. Config view engine (JSP/thymeleaf...etc)

  Spring AOP          Aspect Orinted Programing

          1. config ASOP dependecnies and its providers

  Spring Data/ORM     Persistence Management 

         1. config database proeprties and drivers
         2. config list of dao classes that are to be managed ..etc


  Spring Boot offers AutoConfiguaration
  ------------------------------------------------

     spring boot provide dependencies called starters

     and when ever such moduel dependency is detected in pom.xml,
     te moduelk related default configuarations are automatically done
     and the developer can start working on the applicaton directly.

     But developer need not stick to the configs that are done, we can
     customize them through spring boot properties in application.properties.


  Spring Boot Featues
  -----------------------------

      Embeded Servers
          (+) the applciation become executable on stand-alone mode.
          (+) such applications are called ServerLess applciation are very good for containerization

      Dev Tools

  Runner
  ---------------------------------------

    ApplicationRunner
    CommandLineRunner

  Spring Boot chooses naming and project structure conventions over configuaration.

    src\java\
      com.cts.projectname
          Spring Boot Application Class   
              (@SpringBootApplication = @Confugaration + 
              @EnableAutoConfiguaration + @ComponentScan("com.cts.projectname") +
              +@ProeprtySource("classpath:application.properties"))
      
      com.cts.projectname.subPack1
      com.cts.projectname.subPack2
      com.cts.projectname.subPack3       

Spring Boot Projects <=> Spring Stater Projects
-----------------------------------------------------

Spring Boot Starter         http://start.spring.io

Using Spring Boot CLI

Using STS spring starter project wizard.

Spring Data
-------------------------------------------------------

  is a spring module that provides auto implementation of daos.

  Spring Data JDBC            JDBC implementation for all RDBMS
  Spring Data JPA             ORM implementation for all RDBMS
  Spring Data Redis           ORM-nosql implementation for Redis
      ...etc  



        CrudRepository
          JpaRepository

        //custom methods to be autoamtically implemented

          Entity        findByProperty(Type property)
          List<Entity>  findAllByProperty(Type property)
          boolean       existsByProperty(Type property)

        //custom methods to be autoamtically implemented

          @Query("jpa query over here")
          ReturnVal methodName(Type1 p1,Type p2...);

        @Entity
        @Table(name="emps")
        class Employee{
            @Id
            private Long empId;

            //JPA mappings....
        }

        interface EmployeeRepository extends JpaRepository<Employee,Long>{

            Employee findByEmail(String email);
            List<Employees> findByDept(Department dept);
            List<Employees> frindByFirstName(String firstName);
            boolean findByMobile(String mobile);

            @Query("SELECT e FROM Employee e WHERE e.salary between :lowerBound and :upperBound")
            List<Employee> inSalRange(double lowerBound,double upperBound);
        }

   Case Study
   -----------------------------------------------------------------

    A D2H operator portal,

      The D2H operator must be able to 
        1. Add Channels
        2. Add Subscribers
        3. Add Subscriptions to the subscribers
        4. Retrive the list of channels/subscribers/subscriptiosn for a particular subscriber.


Spring Web MVC
------------------------------------------------------------------------------------------------

  Single FrontEnd Controller Pattern

    Client  ←------------------------------------------------------------------------
      |                                                                             |
      |                                                                         [Views]      
      ↓                                                                             ↑
    FrontEnd                                                                        |
    Controller                                                                  [ViewResolver]
(DispatcherServlet) ---[ UrlHandler ]---→  Controlllers { services and respos } ------|

    Controller
        is any sinple POJO marked as @Controller 
        it must provide methods called actions, where
        each action must return either a String or a ModelAndView
        where the String is the view name
        and the ModelAndView is a composition of viewName and models to be rendered on the actual view.

    UrlHandler
        SimpleUrlHandler (default)      @RequestMapping, @GetMapping, ....etc
        ControllerBeanNAmeUrlHandler
        ...etc

    ViewResolver
        XmlResourceViewResolver
        BeanResourceViewResolver
        InternalResourceViewResolver    (default in spring boot)
              prefix and suffix

              actualView = prefix + viewName + suffix

    View      JSP pages

    Web MVC Annotations
    ----------------------------------------------
          @Controller
          @ControllerAdvice
          @RestController
          @RestControllerAdvice
          @RequestMapping
            @GetMapping
            @PostMapping
            @PutMapping
            @PatchMapping
            @DeleteMapping            
            
          @RequestParam           url?parmName1=val&paramName2=val or form data
                                  https://www.google.com/search?q=apples
          @PathVaraible           url/value/value   
                                  http://localhost:7777/subscriptions/5
          @ModelAttribute         Form Data having multiple fields and fetechs the form data into a Model Object.
          @RequestBody

          @ExceptionHandler


  Dynamic Wwb Applciation

      Server                                                            client
            Server-sise-executing programs <-------------------------- REQ
                  generate dynamic html -------html + css+ js -------> RESP

  Single Page Application


      Server                                                                  client
                  <-------------------------------------------------------- First REQ    
          ui-bundle (javascript(spa framework) + CSS +index.htm) ---------> First RESP
                                                                                new pages are generated
                                                                                dynamically using javascript on 
                                                                                the client side

          REST api <------------------------------------------------------ REQ for data
                  -----------------JSON/XML-------------------------------> RESP, data is extreacted from the 
                                                                              resposne is wrapped in a dynamically
                                                                              generated html and pusehed on to
                                                                              the page.

          

  Spring REST api
  -------------------------------------------------------------------------
      
      REST      Representational State Transfer

      @RestController = @Controller + @ResponseBody

      @RestController
      @RequestMapping("/emps")
      class EmployeeApi{

            actins do not return views any more but only models and httpstatus
            we use httpstatus to report sucessful execution or errosome execution

            HttpStatus
              1xx         a req is recieved and under process, taken care by the web-server layer
              2xx         indicate the req is processed successfully, 200-OK
              3xx         a req is beign redirected....,taken care by the web-sever layer
              4xx         indicate that req could not fulfilled because of client side problem
              5xx         indicate that req could not fulfilled because of server side problem
      }
            
      /entities
            GET         retirve entities
            POST        insert an entity
            PUT         update an entity
            PATCH       partial updation on a entity
            DELETE      delete an entity

  Spring Data Rest
  --------------------------------------------------------------------------
    is a sprng module that generates the repos and rest end points autoamtically.

  Spring Security On REST api
  --------------------------------------------------------------------------
    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

    Basic Http Auth
    1. The suernmae and password msut accompany each and every request
    2. the passsword is transported in clear text.

    Token Based Auth
    1. Client has to request for a token by submitting the uid and pwd
      in a secure post req as req body but not as headers.
    2. Server will generate a hashed secret called token.
    3. Client can pass thsi token in the foregoing req headers.
      + username and passeord are sent only once at the time authentication
      + the password is always masked as it goes in the post req body even for the first time

    JWT?
    Json Web Token
        {
          token:"header|payload|signature in hash mode",
        }
        <dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>


    WebSecurityConfiguerAdapter
      The whole security customization or configuaration must happen.

        UserDetailsService::loadUserByUserName
        
        AuthenticationEntryPoint
          receive any exception while AuthenticationManger is authenticating the suer.
        
        Security Filter
          to validate the incoming jwt tokens
      
        BCryptPasswordEncoder

        AuthenticationManagerBuilder
          AutenticationManager

        HttpSecurity
          configuare the access rules.

       



