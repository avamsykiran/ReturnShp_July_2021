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

        @Entity
        @Table(name="emps")
        class Employee{
            @Id
            private Long empId;

            //JPA mappings....
        }

        interface EmployeeRepository extends JpaRepository<Employee,Long>{

        }


  
