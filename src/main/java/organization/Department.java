package organization;

import java.util.Arrays;
import java.util.Comparator;

public class Department {
    private String name;
    private Employee[] employees;
    public Department(String name) {
        this.name = name;
        this.employees = new Employee[0];
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Department(Employee[] employees) {
        this.employees = employees;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEmployeesCount() {
        return this.employees.length;
    }
    public double getEmployeesSalary() {
        double employeesSalary = 0.0;
        for (Employee employee : this.employees) {
            employeesSalary += employee.getSalary();
        }
        return employeesSalary;
    }
    public Employee getEmployeeByName(String lastName, String firstName) {
        for (Employee employee : this.employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        return null;
    }
    public void dismissalsEmployee(String lastName, String firstName, String position) {
        for (int i = 0; i < this.employees.length; i++) {
            Employee employee = this.employees[i];
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)
                    && employee.getPosition().equals(position)) {
                Employee[] newEmployees = new Employee[this.employees.length - 1];
                System.arraycopy(this.employees, 0, newEmployees, 0, i);
                if (this.employees.length != i) {
                    System.arraycopy(this.employees, i + 1, newEmployees, i, this.employees.length - i - 1);
                }
                this.employees = newEmployees;
                return;
            }
        }
    }
    public void receptionEmployee(Employee newEmployee) {
        Employee[] newEmployees = new Employee[this.employees.length + 1];
        System.arraycopy(this.employees, 0, newEmployees, 0, this.employees.length);
        newEmployees[this.employees.length] = newEmployee;
        this.employees = newEmployees;
    }
    public Employee[] getSortedEmployees() {
        Employee[] sortedEmployees = this.getEmployees();
        Arrays.sort(sortedEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                if (employee1.getLastName().equals(employee2.getLastName())) {
                    return employee1.getFirstName().compareTo(employee2.getFirstName());
                }
                return employee1.getLastName().compareTo(employee2.getLastName());
            }
        });
        return sortedEmployees;
    }
}
