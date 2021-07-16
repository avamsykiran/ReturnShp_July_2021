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

     JPA
     ----------------------------------------------

        Java Perssitence API

                is a specification (a set of abstract declarations) of an ORM implementation

        JPA implementations
                Hibernate
                TopLink
                iBates
                .....etc
