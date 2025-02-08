package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class InsertData {




    public static void main(String[] args) {
        System.out.println("heelo");
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;

        try{
//            load and register mysql driver
            Class.forName("com.mysql.cj.jdbc.Driver");

//            for oracle
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            establish a connection
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","root");

            statement=connection.createStatement();
            String query="insert into employee (name,bsal,dept) values('yaar badashah',5000,'cse') ; ";
//String query="update employee  set bsal=6000 where name ='yaar badashah';";

//String query="update employee  set bsal=6000 , name='Aman',dept='IT' where empid=14;";
//String query="delete from employee where name='yaar badashah'";

//
//            rs= statement.executeQuery(query);
            int count=statement.executeUpdate(query);
            if(count>0){
//                System.out.println("record insert successfullly");
//                System.out.println("record update successfully");
                System.out.println("record delete successfully");
            }
            else{
                System.out.println("please check there is some error");
            }
        }
        catch (ClassNotFoundException e){
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    }

