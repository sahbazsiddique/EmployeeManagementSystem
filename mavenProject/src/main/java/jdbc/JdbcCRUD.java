package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcCRUD {
    Connection connection=null;
    Statement statement=null;
    ResultSet rs=null;

    static String update() {

        return "update employee  set bsal=6000 , name='Puneet',dept='IT' where empid=18;";

    }

    static String insert() {
        return "insert into employee (name,bsal,dept) values('Akash',5000,'cse') ; ";


    }

    static String delete() {
        return "delete from employee where empid=18 ;";


    }

    public static void main(String[] args) {

        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","root");
            statement=connection.createStatement();
//            int count=statement.executeUpdate(update());
            int count=statement.executeUpdate(delete());
//            int count=statement.executeUpdate(insert());


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





