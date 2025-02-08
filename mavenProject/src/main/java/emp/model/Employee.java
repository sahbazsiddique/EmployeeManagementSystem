package emp.model;

import java.util.Objects;

public class Employee {

    private int empId;
    private String name;
    private double bSal;
    private String deptName;


    public Employee( String name, double bSal, String deptName) {
        this.name = name;
        this.bSal = bSal;
        this.deptName = deptName;
    }

    public Employee( int empId,String name, double bSal, String deptName) {
        this.name = name;
        this.empId=empId;
        this.bSal = bSal;
        this.deptName = deptName;
    }

    public Employee(){


    }




    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getbSal() {
        return bSal;
    }

    public void setbSal(double bSal) {
        this.bSal = bSal;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && Double.compare(bSal, employee.bSal) == 0 && Objects.equals(name, employee.name) && Objects.equals(deptName, employee.deptName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name, bSal, deptName);
    }

    @Override
    public String toString() {
        return
                "\nempId=" + empId +
                ", name='" + name + '\'' +
                ", bSal=" + bSal +
                ", deptName='" + deptName + '\'';
    }
}


