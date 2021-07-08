Java 11
----------------------------------------------------------------------------

    Evaloution History and Features
    Data Types
    Tokens
        Identifiers
        Keywords
        Operators
        Comments
        Literals
    Control Structures
    java.lang Fundas
        Object
        System
        Math
        String
        StringBuffer
        StringBuilder
        Wrapper Classes
    Exceptions
        Throwable
        Exception and CheckedExceptions
        RuntimeException and UnChekcedExceptions

            we are not expected to handle unchecked exceptions but we msut avoid unchecked exception
            beacuse they can be avoided through defensive programming.

                public void doubleSal(Employee emp){
                    if(emp!=null){
                        emp.setSal(emp.getSal()*2);
                    } 
                }

                public Employee getEmpAt(int index){
                    Employee emp = null;

                    if(index>=0 && index<empList.size()){
                        emp = empList.get(index);
                    }

                    return emp;
                }

            Checked exceptions are not logically controlable by a program and hence
            can not be avoided and hence msut be handled mandatly.



        Suppressed Exceptions

            Connection con = null;

            try{
                con = DriverManager.getConnection(url,uid,pwd);
                .............
            }catch(SQLException exp){
                ..............
            }finally{
                try{
                    con.close();
                }catch(SQLException exp){
                    ..............
                }
            }

         try-with-resources

            try(Connection con =DriverManager.getConnection(url,uid,pwd)){
                ...............
            }catch(SQLException exp){
                ..............
            }

        try-with-multi-catch

            try{
                ...........................
            }catch(IOException | SQLException exp){
                    ...20 limne of code..
            }


    