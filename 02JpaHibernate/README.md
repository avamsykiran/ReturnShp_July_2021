ORM
------------------------------------------------------------------

        Object Relational Mapping

                        OOPs                                   RDBMS
    ======================================================================================================

    EntityDef           Class                                  Table (Schema)
    Entity              Object                                 Row
    Property            Field (data member)                    Col
    Behaviour           Method                                 -----------------

    IS A                Inheretence                            Single Table for entire hirarchy
                                                               Joined Tables
                                                               Isolated Tables
    Has A
    (Assosiation)
     Composition        Embeded                                Single Table

                        class Address{                          emps
                          - dno:String                                  empid(PK),full_name,dno,street
                          - street:String
                        }

                        class Employee{
                          - empId:Integer
                          - fullName:String
                          - address:Address
                        }

     Aggregation
        OneToOne        class BankAccount{                      Joins
                          - accNumber:Long                         bank_accounts        acc_no(PK),bank,ifsc,empid(FK)
                          - bankAndBranch:String                   emps                 empid(PK),full_name,acc_no(FK)
                          - infscCode:String
                          - accHolder:Employee
                        }

                        class Employee{
                          - empId:Integer
                          - fullName:String
                          - salAccount:BankAccount
                        }

        OneToMany       class Department {                      Joins
                          - deptId:Long                            depts        deptno(PK),dname
                          - name:String                            emps         empid(PK),fulkl_name,deptid(FK)
                          - emps: Set<Employee>
                        }

         ManyToOne      class Employee{
                          - empId:Long
                          - fullName:String;
                          - department:Department;
                        }

        ManyToMany      class Project {                         JoinTable
                          - projId:Long;                           prjs         prjhid(PK),title
                          - prjTitle:String;                       emps         empId(PK),full_name
                          - team:Set<Employee>;                    prj_emps     PK(prijid(FK),empId(FK))
                        }

                        class Employee{
                          - empId:Long
                          - fullName:String;
                          - projects:Set<Project>
                        }

        Broken ManyToMany      
                        
                        class Project {                         JoinTable
                          - projId:Long;                       prjs         prjhid(PK),title
                          - prjTitle:String;                   emps         empId(PK),full_name
                          - team:Set<ProjEmpDetails>;          prj_emps     PK(prijid(FK),empId(FK)),f_dt,t_dt,role
                        }

                        class Employee{
                          - empId:Long
                          - fullName:String;
                          - projects:Set<ProjEmpDetails>;
                        }

                        class ProjectDetails {
                          - empId:Long;
                          - projId:Long
                          - fromDate:LocalDate;
                          - toDate:LocalDate
                          - role:String;
                        }

     JPA
     ----------------------------------------------

        Java Perssitence API

                is a specification (a set of abstract declarations) of an ORM implementation

        JPA implementations
                Hibernate
                TopLink
                iBates
                .....etc

        JPA api

          Persistence                 createEntityManagerFactory(Strign persistencUnitName);
          EntityManagerFactory        createEntityManager();
          EntityManager
                                      persist(entity);      //insertion
                                      merge(entity);        //updation
                                      remove(entity);       //deletion
                                      load(id)
                                      get(id)
                                      getTransaction()      EntityTransaction
                                      flush()               commit all transactiona dn then closes them
                                      close()               commits all trnasactions and cloases the entity manager itself.
                                      createQuery(String qry)                                Query
                                      createQuery(String qry,EntityClass)                    TypedQuery
                                      createNamedQuery(String qryName)                       Query
                                      createNamedQuery(String qryName,EntityClass)           TypedQuery


        JPA Entity Lifecycle

            Transiant
                          Entity e = new Entity()

            Persistant
                          em.persist(e);              Entity e2 = em.get(id);   em.merge(e2);

            Detached
                          em.getTransaction().commit();
                          em.getTransaction().rollback();
                          em.flush();
                          em.close();

        JPA Annotations 
      
          @Entity                 class
          @Table(name="")         class

          @Id                     field         primary key
          @Column                 field         customize col properties liek col name,nullabe,unique ..etc

          @Transiant              field         skip from being persisted

          @OneToOne               field
          @OneToMany              field
          @ManyToOne              field
          @ManyToMany             field

          @JoinColumn             field
          @JoinTable              field

          @Embedable              class
          @Embeded                field

          @Inheretence            class
          @DiscriminatorColumn    class
          @DiscriminatorValue     class

          @GeneratedValue         field
          


    

