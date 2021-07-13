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

                            collect     is used to collect data from a stream, into a set/list/map.

                                        streamObject.collect(Collectors.toList())
                                        streamObject.collect(Collectors.toSet())
                                        streamObject.collect(Collectors.toMap(howToGetKey,howToGetValue))

                        Stream Operations - Intermedate - that return another stream
                            filter      accepts a predicate
                                        apply this predicate on each value ofd the old stream
                                        and returns stream of thos valeu that give true for the predicate.

                            map         accepts a mapper function
                                        return a new stream of mapped values of the ele in the older stream.

                                        int[] nums = new int[]{1,2,3,4,5};
                                        Stream.of(nums).map(n->n*n).collect(Collector.toList());
                                        Stream.of(nums).map(n->n/2).collect(Collector.toList());
                                        Stream.of(nums).map(n->"Hello "+n).collect(Collector.toList());    
                                        Stream.of(nums).filter(n->n%2==0).map(n->n*n).collect(Collector.toList());
                            
                            flatMap     used to flatten a 'stream of stream' into a 'stream'.

                            distinct    return a new stream of non-duplicate valeus from an older stream.


        List<String> empStrList = 
            emps.stream()
            .filter(e -> e.getBasic()<=30000)
            .map(e -> e.getFullName() + " is earning as little as INR."+e.getBasic())
            .collect(Collectors.toList());

        List<String> empStrList = new ArrayList<>();
        for(Employee e : emps){
            if(emp.getBasic()>=30000){
                empStrList.add(e.getFullName() + " is earning as little as INR."+e.getBasic());
            }
        }

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


                        step1           
                                Load Driver
                                Class.forName("fullyQualifiedDriverClassNAme");
                                DriverManager.registerDriver(new DriverClass());

                                //this step is automated, the driver is loaded autoamtically 
                                //if its is present in the classpath
                        
                        step2

                            Connection con = DriverManager.getConnection(DbUrl,uid,pwd);

                        step3


                            3.a. Retrive Database details
                                    
                                    DatabaseMetadata dbmd = con.getMetadata();

                            3.b. DDL,DML,DRL operations

                                Statement st = con.createStatement();
                                PreparedStatement pst = con.prepareStatement(qry); //supports paramedQrys


                                st.execute(ddlQry)              boolean
                                st.executeUpdate(dmlQry)        int
                                st.executeQuery(drlQry)         ResultSet

                                pst.execute()              boolean
                                pst.executeUpdate()        int
                                pst.executeQuery()         ResultSet

                            3.c. Proc/Func Call

                                CallableStatemetn cst = con.prepareCall(procOrFuncCall);


        Case Study
        -----------------------------------------------------------------

            1. App should display a menu:

                1. Upload Report
                2. Display Summarry
                3. Quit

            2. When '1' is choosen 

                ask for the file names eg: 'sampleData.txt'
                verify if the sampleData.txt is a commas seprated records file:
                    1,Item1,CMR Shopping Mall,56,56000,1000,01-JUN-2021
                    2,Item2,CMR Shopping Mall,16,16000,1000,01-MAY-2021
                    3,Item3,MVV Shopping Mall,6,6000,1000,01-FEB-2021
                    4,Item2,MVV Shopping Mall,156,156000,1000,01-APR-2021
                    5,Item3,CMR Shopping Mall,66,66000,1000,01-FEB-2021
                        
                where each line represents a sales record with fields 
                receiptNumber,itemName,area,unitsSold,totalCollection,rate,soldDate

                and convert each of  such line into a relevent java object
                and insert them into a table in the database (mysql).

                if any record format mismatches, a relevent err msg shall be displayed and
                the rest of the records must be processed,

                finally diplay the numberOfRecordsSaved out of numberOfRecordsInFile
            
            3. When '2' is choosen 

                accept a start date and an end date
                retrive all sales recoreds with in the given dates from the database table,
                and display a report as below

                        assuming dates range is 01-Feb-2021 to 31-Jun-2021

                ItemName    Feb2021     Mar2021     Apr2021     May2021 Jun2021

                Item1       26 26000    0 0         12  13450   ......  .......
                Item2       .......     .......     .......     ....... .......     
                Item3       .......     .......     .......     ....... .......
                Item4       .......     .......     .......     ....... .......
                ....        .......     .......     .......     ....... .......