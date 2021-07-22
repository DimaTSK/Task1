package human;

import viewdepartments.View;

import java.math.BigDecimal;

public class Employee {
    private String name;
    private BigDecimal salary;

    public Employee(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

     String print(Department department) {
        return  String.format("%-" + department.getMaxSizeName()+ "s - %"+department.getMaxSizeSalary()+"s  %n", getName(), getSalary());

    }

    public String getName() {
        return name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}