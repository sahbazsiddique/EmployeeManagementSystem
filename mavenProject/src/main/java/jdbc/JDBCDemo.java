package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {


    public static void main(String[] args) {
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
            String query="select * from city ; ";

//
            rs= statement.executeQuery(query);

            while(rs.next()){
                System.out.println(rs.getInt(1)+ "\t"+ rs.getString(2)+" \t"+rs.getDouble(5)+"\t");
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
