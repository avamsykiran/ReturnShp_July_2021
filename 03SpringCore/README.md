Spring
------------------------------------------------------------------

  Lab Setup
      JDK 1.8 and /or JDK11
      Chrome
      STS latest

  Spring 5 is a java development platform, and is an amolgamation of various moduels, dev tools and supports emebeded servers.

    where each spring moduel itself is a framework:

    Spring Core
    Spring Beans
    Spring Context
    Spring SpEl
    Spring JDBC
    Spring Data
    Spring Web    
    Spring AOP
    Spring Aspect
    Spring Test
    Spring ORM
    Spring Cloud
    Spring Security
    .......................etc


    1. it is a Light weight container (DI)
    2. it is Moduler hence ensure sleak or slim build bundles
    3. it is Pluggable


Dependency Injection is an proposed impl of IoC
------------------------------------------------------------------------------------------

  interface DAO{

  }

  class DAOJdbcImpl implements DAO{

  }

  class DAOOrmImpl implements DAO{

  }

  interface Service{

  }

  class ServiceImpl implements Service {

    private DAO dao;  //service depends on dao

    public ServiceImpl(DAO dao){ //constructor injection 
      //this.dao = new DAOJdbcImpl();
      //this.dao = new DAOOrmImpl();
      this.dao=dao;
    }
  }

Spring Core 
------------------------------------------------------------

 context is always referes to the Container Instacne.

  Container is a sofware component who does the instantiation of all requried componnent like
  daos, services, controllers ...etc and also does the injection whereever and whenever required.

  Spring Context offers us 
    1. BeanFactory
    2. ApplicationContext
        WebApplicationContext
        XMLConfigApplicationContext
        AnnotationConfigApplicationContext
        WebAnnotationConfigApplicationContext

  Spring Configuaration
  -------------------------------

    it is about informing the spring container (ApplicationContext)
    about 
      1. how many software components (daos,services,controller..etc) do we have 
      2. and which software component is dependent on the other.

    Xml Based Configuareation

    Annotation Based configuaration
    -------------------------------------
      @Configuaration      class level 

      @Component ("id")    class level      informing that we need the contaienr to create and  
                                            manage an obejct of the class that is applied with this annotation.

      @Component
        @Service
        @Repository
        @Controller
        @RestController
        @ControllerAdvise
        @RestControllerAdvise ...etc


      @ComponentScan({"package1","package2",...})   class level  applied along with @Configuaration

      @Value("${propertyName:defaultValue}")        Field level

      @Value("#{beanid.field:defaultValue}")        Field level

      @PropertySource("propertyFielPath")           class level  applied along with @Configuaration

      @Scope                            class level   applied along with @Component
              singleton       each getBean call the same object is given
              prototype       each getBean call a new object is given
              
              request         works only in WebApplicationContext
              session         works only in WebApplicationContext
              global-session  works only in WebApplicationContext

      @Autowired                        Field level / method level
      @Qualifer                         Field level / method level  used along with @Autowired
      @Primary                          Class level 

    Java Based Configuaration
    ---------------------------------------

      @Configuaration
      class Config{

        @Bean
        public Random random(){
          return new Random(23);
        }

      }
