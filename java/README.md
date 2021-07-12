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

        Interface Improvements

                1. static methods
                2. default methods
                3. functional interface

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

        functional interface

                any interface that has only one abstract method.
                @FunctionalInterface is a compiler check annotation to ensure that the functional interrface 
                shall not have more then one abstract method..

                as know any interface msut be implemnted
                by a concret or anonymous class.

                but functional interface apart from beign capable of getting implemented by concrete or abstract classes, it can be impl;emented using a lambda expression alos.

                @FunctionalInterface
                interface BinOperator{
                    double do(double a,double b);
                }

                java.util.function
                        Suppliers           has a return val, but no arguments
                        Consumers           has no return val, but has arguments
                        Predicates          returns boolean always
                        Operator            the arg datatype and return type are same
                        Functional          has a return val and also has arguments


        Lambda Expressions
                BinOperator sum = (a,b) -> a+b;
                int result = sum.do(10,20); 
        
        Method Referencing
                BinOperator p = Math::pow;
                double d1 = p.do(2,5);
                double d2 = Math.pow(2,5);
                System.out.println(d1==d2);//true

        java.util.stream

                    is a flow of data from a collection(set/list/map) or an array.

                        Stream s1 = Stream.of(array);
                        Stream s2 = list.stream();
                        Stream s2 = set.stream();

                        Stream Operations - Terminal  - that retrun zero or one object
                            forEach     accepts a consumer,
                                        executes this consumer on each and every ele of the stream.

                            reduce      accepts a BinaryOperator
                                        executes the BO on each pair of eles on the stream
                                        and return the final value.

                                        int[] nums = new int[]{1,2,3,4,5};
                                        Stream s1 = Stream.of(nums);
                                        BinaryOperator<Integer> bo = (n1,n2) -> n1+n2;
                                        Optional<Integer> result = s1.reduce(bo);
                                            //bo.apply(bo.apply(bo.apply(bo.apply(1,2),3),4),5)
                                            //15


                            collect

                        Stream Operations - Intermedate - that return another stream
                            map
                            flatMap
                            filter
                            
                       

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
