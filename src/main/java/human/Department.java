package human;

import writefile.WriteFileInfCompany;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employeeList = new ArrayList<>();
    private String name;

    private int maxSizeName;
    private  int maxSizeSalary;


    public int getMaxSizeName() {
        return maxSizeName;
    }

    public void setMaxSizeName(int maxSizeName) {
        this.maxSizeName = maxSizeName;
    }

    public int getMaxSizeSalary() {
        return maxSizeSalary;
    }

    public void setMaxSizeSalary(int maxSizeSalary) {
        this.maxSizeSalary = maxSizeSalary;
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(){

    }

    public void addEmployee(Employee employee) {

        if (employee.getName().length()>getMaxSizeName()){
            setMaxSizeName(employee.getName().length());
        }
        if (employee.getSalary().toString().length()>getMaxSizeSalary()){
            setMaxSizeSalary(employee.getSalary().toString().length());
        }

        getEmployeeList().add(employee);
    }

    public BigDecimal getAvgSalaryWithOutEmployee(Employee employee){
        BigDecimal salary = getSalary();
        BigDecimal salaryWithOutEmployee = salary.subtract(employee.getSalary());
        return salaryWithOutEmployee.divide(BigDecimal.valueOf(getEmployeeList().size()-1),2,RoundingMode.HALF_UP);
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }


    public BigDecimal getAvgSalary() {
        if (getEmployeeList().size() == 0) {
            return BigDecimal.ZERO;
        }

        return getSalary().divide(BigDecimal.valueOf(getEmployeeList().size()), 2, RoundingMode.HALF_UP);
    }

    public void print(WriteFileInfCompany writeFileInfCompany) {

        writeFileInfCompany.writeFile("Department - "+getName()+" : "+" Average salary -  "+getAvgSalary()+("\n"));
        for (Employee employee : getEmployeeList()) {
            writeFileInfCompany.writeFile(employee.print(this));
        }
        writeFileInfCompany.writeFile("-------\n");

    }


    public BigDecimal getSalary() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Employee employee : getEmployeeList()) {
            sum = sum.add(employee.getSalary());
        }
        return sum;
    }
}
