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


    Java Standard Libraries
    -------------------------------------------------------------------------------------

        java.lang
                        Object
                        String
                        StringBuffer
                        StringBuilder
                        System
                        Math
                        Wrapper Classes
                        Throwable
                        Exception
                        RuntimException
                        Runnable
                        Thread
                        Comparable

        java.time
                        LocalDate
                        LocalTime
                        LocalDateTime
                        ZonedDateTime
                        Period
                        Duration
                        DateTimeFormatter


                        Assignment:
                            Accept the Principle, RateOfInterest, NoOfEMIS and firstEmiDueDate,
                            compute and display the below

                            EMI#       EmiDueDate       EMI         PrincipalComponent      InterestComponent
                            1           
                            2
                            3



        java.util
                        Scanner
                        Random

                        Collection
                            List
                            Set
                                SortedSet
                        Map
                            SortedMap

                        List <--------- ArrayList, Vector, LinkedList
                        Set <---------- HashSet, TreeSet, LinkedHashSet
                        Map <---------- HashMap, TreeMap, LinkedHashMap

                        Iterator
                        ListIterator
                        Comparator
                        Collections

                        Navigable Collections

        java.util.function
                        interfaces as in java8

                        Suppliers
                        Consumers
                        Predicates
                        Functional

                        Method Referencing and Lambda Expressions

        java.util.stream
                        Stream
                                forEach
                                reduce
                                map
                                flatMap
                                collect
                                filter
                                .....
                        Collectors

        java.io
                        Character Streams             Binary Streams
                                Reader                      InputStream
                                    BufferedReader                  FileInputStream
                                    FileReader                      DataInputStream
                                    InputStreamReader               ObjectInputStream

                                Writer                      OutputStream
                                    FileWriter                      FileOutputStream
                                                                    DataOutputStream
                                                                    ObjectOutputStream

                        File, IOException,....
        java.nio
                        Files
                        Path
                        .....

        java.sql
                        DriverManager
                        Connection
                        Statement
                        PreparedStatement
                        CallableStatement
                        ResultSet
                        ResultSetMetadata
                        DatabaseMetaData
