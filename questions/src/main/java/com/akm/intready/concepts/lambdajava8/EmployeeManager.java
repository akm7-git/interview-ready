package com.akm.intready.concepts.lambdajava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeManager {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws NoSuchFieldException {
        employees.add(new Employee("alok", "mishra", 7000d, "sebu"));
        employees.add(new Employee("carla", "grant", 12000d, "hcx"));
        employees.add(new Employee("Alex", "Wu", 19000d, "sd"));
        employees.add(new Employee("Sim", "bala", 9000d, "sd"));


        //JAVA 8 stream example
        employees.stream().forEach(employee -> System.out.println(employee));

        //map usage
        // Salary incremented by 30 percent for all the employees and stored in a new List

        List<Employee> revisedEmployeeSalary =
                employees.stream()
                        .map(emp -> new Employee(
                                emp.getFirstName(),
                                emp.getLastName(),
                                emp.getSalary() * 1.3,
                                emp.getDepartment()))
                        .collect(Collectors.toList());
        System.out.println("\n \n *** Salaries after hike **** \n \n ");

        revisedEmployeeSalary.stream().forEach(employee -> System.out.println(employee));

        //stream filter example, filter an object with criteria
        // Increase salary of employee, for whom salary is less than 10k (:p)

        System.out.println("\n \n *** Salaries after hike for specific employee **** \n \n ");
        List<Employee> revisedEmployeeSalaryForPoorEmployee = employees.stream().filter(employee -> employee.getSalary() < 10000d).map(emp ->
                new Employee(emp.getFirstName(), emp.getLastName(), emp.getSalary() * 2, emp.getDepartment()))
                .collect(Collectors.toList());

        revisedEmployeeSalaryForPoorEmployee.stream().forEach(employee -> System.out.println(employee));

        // findFirst example, get the first element of the streamed List

        Employee firstEmployee = employees.stream().map(emp -> new Employee(
                emp.getFirstName(), emp.getLastName(), emp.getSalary() * 1.3, emp.getDepartment()))
                .findFirst().orElse(null);
        System.out.println("\n \n *** First employee data **** \n \n ");
        System.out.println(firstEmployee.toString());

        //Get employee whose salary is for than 10k
        Employee eligibleEmployee = employees.stream().filter(emp -> emp.getSalary() > 10000d).map(emp -> new Employee(
                emp.getFirstName(), emp.getLastName(), emp.getSalary(), emp.getDepartment())).findFirst().orElse(null);

        System.out.println("\n \n *** Employee data whose salary is 10k+ **** \n \n ");
        System.out.println(eligibleEmployee.toString());

        //Get employee whose salary is for than 100k, it should return null
        Employee eligibleEmployee1 = employees.stream().filter(emp -> emp.getSalary() > 100000d).map(emp -> new Employee(
                emp.getFirstName(), emp.getLastName(), emp.getSalary(), emp.getDepartment())).findFirst().orElse(null);

        System.out.println("\n \n *** Employee data whose salary is 100k+ **** \n \n ");
        if (null == eligibleEmployee1) {
            System.out.println("filter has returned null");
        }

        //Flatmap example
        String departments = employees.stream()
                .map(employee -> employee.getDepartment())
                .distinct().collect(Collectors.joining(","));
        System.out.println("\n \n *** Distinct departments **** \n \n ");
        System.out.println("Distinct Departments are : " + departments);

        String names = employees.stream()
                .map(employee -> employee.getFirstName())
                .flatMap(fn -> Stream.of(fn)).collect(Collectors.joining(","));

        System.out.println("\n \n *** First Names of Employee **** \n \n ");
        System.out.println("First names of employees are : " + names);

        //skip and limit
        List<Employee> secondAndThirdEmployees = employees.stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("\n \n ***2nd & 3rd Employee details **** \n \n ");
        secondAndThirdEmployees.stream().forEach(emp -> System.out.println(emp));

        System.out.println("\n \n ***Limit infinite data to finite data using limit **** \n \n ");
        //finite data
        Stream.generate(Math::random)
                .limit(4)
                .forEach(val -> System.out.println(val));

        //sorting of data
        System.out.println("\n \n ***Sorting of  Employee details on the basis of salary **** \n \n ");

        List<Employee> sortedEmp = employees.stream()
                .sorted(((o1, o2) -> o1.getSalary().compareTo(o2.getSalary())))
                .collect(Collectors.toList());

        sortedEmp.stream().forEach(e -> System.out.println(e));

        //min or max
        System.out.println("\n \n *** Get Max Salary **** \n \n ");
        Double maxSal = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NoSuchFieldException::new).getSalary();

        System.out.println("Max salary : " + maxSal);


        System.out.println("\n \n *** Get Total Salary given to employees **** \n \n ");
        double sum = employees.stream()
                .map(emp -> emp.getSalary())
                .reduce(0.0, Double::sum);

        System.out.println("Total Salary paid out to employee : " + sum);
    }
}
