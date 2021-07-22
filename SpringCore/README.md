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

  