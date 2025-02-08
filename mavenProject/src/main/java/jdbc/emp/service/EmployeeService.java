package jdbc.emp.service;

import com.jdbc.emp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    List<Employee> getEmployeeById(int empId);
//    void search(int empId);

    Employee getSearchById(int empId);

    // adding new employee

    void addEmployee(Employee emp);

  void update(Employee emp,int empId);
    void delete(int empId);



}
