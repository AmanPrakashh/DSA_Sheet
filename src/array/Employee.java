package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Employee {
    String name;
    String dept;
    int salary;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        List<Employee> employees= new ArrayList<>();
        Employee employee1 = new Employee("Aman", "SDE", 0);
        Employee employee2 = new Employee("Aman Prakash", "SDE", 0);
        Employee employee3 = new Employee("Rajput", "Manager", 0);
        Employee employee4 = new Employee("Arvind", "Manager", 0);
        Employee employee5 = new Employee("Arvind Rajput", "Manager", 0);

        employees.add(employee1);
        employees.add(employee3);
        employees.add(employee2);
        employees.add(employee4);
        employees.add(employee5);


        Map<String, Long> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(collect);
    }
}
