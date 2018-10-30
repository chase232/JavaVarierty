/*
 * This class is used to calculate payroll for our employees
 * 
 */

package com.oreillyauto.w0501;

import java.math.BigDecimal;
import java.util.List;

public class Payroll {
    
    // Calculates payroll for every employee
    public BigDecimal calculatePayroll(List<OreillyEmployee> employeeList) {
        
        BigDecimal salary = new BigDecimal(0);
        BigDecimal newSalary = new BigDecimal(0);
        for(OreillyEmployee employee : employeeList) {
            
            newSalary = employee.getSalary();
            salary = salary.add(newSalary);
        }
        return salary;
    }
    
    // Calculates payroll for employees based on a specific title
    public BigDecimal calculatePayroll(List<OreillyEmployee> employeeList, String title) {
        
        BigDecimal salary = null;
        for(OreillyEmployee employee : employeeList) {
            
            if ((employee.getTitle()).equals(title)) {
                salary = employee.getSalary();
                salary.add(salary);
            }  
        }
        return salary;
    }
    
    // Gives a raise to everyone
    public void giveRasises(BigDecimal raiseAmount, List<OreillyEmployee> employeeList) {
        
        BigDecimal salary = new BigDecimal(500);
        for(OreillyEmployee employee : employeeList) {
            employee.setSalary(employee.getSalary().add(salary));
        }
    }
    
    // Increments the age of the specified employee
    public void happyBirthday(OreillyEmployee employeeOne) {
        
        employeeOne.setAge(employeeOne.getAge() + 1);
    }
}
