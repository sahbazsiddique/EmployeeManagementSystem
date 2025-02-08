package jdbc.emp.service;

import com.jdbc.emp.model.Employee;
import com.jdbc.emp.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
//     List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getEmployees() {
        Employee emp=null;

        List<Employee>  employees=new ArrayList<>();
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        try{
            connection= DbUtil.getDbConnection();
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","root");

            statement=connection.createStatement();
            String query="select * from employee ; ";
            rs= statement.executeQuery(query);

            while(rs.next()){
                emp=new Employee();

                emp.setEmpId(rs.getInt(1));
                emp.setName(rs.getString(2));
                 emp.setbSal(rs.getDouble(3));
                 emp.setDeptName(rs.getString(4));
                 employees.add(emp);
            }


            }
        catch (ClassNotFoundException e){
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }
return employees;
    }


    @Override
    public List<Employee> getEmployeeById(int empId) {
        Employee emp=null;
        List<Employee>  employees=new ArrayList<>();
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            connection= DbUtil.getDbConnection();


            String query="select * from employee  where empId = ?";
            ps=connection.prepareStatement(query);
ps.setInt(1,empId);
            rs= ps.executeQuery();


            while(rs.next()){
                emp=new Employee();

                emp.setEmpId(rs.getInt(1));
                emp.setName(rs.getString(2));
                emp.setbSal(rs.getDouble(3));
                emp.setDeptName(rs.getString(4));
                employees.add(emp);
            }
            boolean found=false;
            for (Employee e : employees) {
                if (e.getEmpId() == empId) {
                    found= true;
                    break;
                }
            }

            if (found) {
                System.out.println("Employee with empId " + empId + " exists.");
            } else {
                System.out.println("Employee with empId " + empId + " does not exist.");

            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return employees;
    }


    @Override
    public Employee getSearchById(int empId) {

        Employee emp=null;
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {


            connection = DbUtil.getDbConnection();
            String query = "select * from employee where empid = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1,empId);

            rs=ps.executeQuery();
            if(rs.next()){
                emp=new Employee();
                emp.setEmpId(rs.getInt(1));
                emp.setName(rs.getString(2));
                emp.setbSal(rs.getDouble(3));
                emp.setDeptName(rs.getString(4));

            }



        }
        catch (SQLException e){
            System.out.println(e);
        }

        return emp;
    }


    @Override
    public void update(Employee emp,int empId) {
        Connection connection=null;
        PreparedStatement ps=null;



        try {
            connection = DbUtil.getDbConnection();
            String query = "update employee set bsal=? , name=? ,dept =? where empid=?  ";
            ps = connection.prepareStatement(query);
            ps.setDouble(1,emp.getbSal());
            ps.setString(2,emp.getName());
            ps.setString(3,emp.getDeptName());
            ps.setInt(4,empId);


            int count=ps.executeUpdate();
            if(count>0){
                System.out.println("update successfully ");
            }
            else{
                System.err.println("Employee not found ");
            }




        }
        catch (SQLException e){
            System.out.println(e);
        }




    }
    @Override
    public void delete(int empId) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DbUtil.getDbConnection();
            String query = "delete from  employee where empid=?  ";

            ps = connection.prepareStatement(query);

            ps.setInt(1,empId);
            int count=ps.executeUpdate();
            if(count>0){
                System.out.println("delete  successfully ");
            }
            else{
                System.err.println("Employee not found ");
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }


    @Override
    public void addEmployee(Employee emp){
        Connection connection=null;
        PreparedStatement ps=null;

        try {
            connection = DbUtil.getDbConnection();
            String query = "insert into employee(name,bsal,dept) values(?,?,?)";
            ps = connection.prepareStatement(query);

            ps.setString(1,emp.getName());
            ps.setDouble(2,emp.getbSal());
            ps.setString(3,emp.getDeptName());

            int count=ps.executeUpdate();
            if(count>0){
                System.out.println("insert successfully ");
            }
            else{
                System.err.println("some err are occurred in insert ");
            }




        }
        catch (SQLException e){
            System.out.println(e);
        }


    }

//    public void search(int empId){
//
//
//        boolean empFound = false;
//
//        // Loop through the global 'employees' list to find if any employee matches the empId
//        for (Employee e : employees) {
//            if (e.getEmpId() == empId) {
//                empFound = true;  // Set to true if empId is found
//                System.out.println("Employee found: " + e.getName() + " with empId " + empId+" "+e.getDeptName()+" and balance is : "+e.getbSal());
//                break;  // Exit loop once found
//            }
//        }
//
//        // If employee not found, print message
//        if (!empFound) {
//            System.out.println("Employee with empId " + empId + " does not exist.");
//        }
//    }



}
