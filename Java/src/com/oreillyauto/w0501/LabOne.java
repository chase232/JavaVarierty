/*
 * Program:     LabOne
 * Developer:   Chase Dickerson 
 * Date:        10/29/2018
 * Purpose:     Used to test methods of class/object oriented programming
 */

package com.oreillyauto.w0501;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * This class holds all of the testing statments and output
 */
public class LabOne {
        
        // global instance of the class PayRoll
        Payroll payroll = new Payroll();
        
        // Main class
        public static void main(String args[]) {
            
            new LabOne();
        }

        public LabOne() {
            OreillyEmployee employeeOne = new OreillyEmployee(1, 30, "Jeffery Brannon", new BigDecimal("40000.00"), "Supervisor");
            OreillyEmployee employeeTwo = new OreillyEmployee(1, 30, "Nick Jaross", new BigDecimal("40000.00"), "Manager");
            
            List<OreillyEmployee> employeeList = new ArrayList<OreillyEmployee>();
            
            employeeList.add(employeeOne);
            employeeList.add(employeeTwo);
    
            System.out.println("Total Payroll: " + payroll.calculatePayroll(employeeList));
            System.out.println("Manager Payroll: " + payroll.calculatePayroll(employeeList, "Manager"));
    
            System.out.println("Giving A $500 raise to each employee...");
            giveAnnualRaiseForDepartment(new BigDecimal("500.00"), employeeList);
            // giveAnnualRaiseForDepartment(new BigDecimal("500.00"));
    
            System.out.println("Total Payroll: " + payroll.calculatePayroll(employeeList));
            System.out.println("Manager Payroll: " + payroll.calculatePayroll(employeeList, "Manager"));
    
            System.out.println("Age Check:");
    
            for (OreillyEmployee employee : employeeList) {
                System.out.println("Name: " + employee.getName() + " Age: " + employee.getAge());
            }
    
            payroll.happyBirthday(employeeOne);
            System.out.println("Jeffery Had A Birthday!");
    
            System.out.println("Age Check:");
    
            for (OreillyEmployee employee : employeeList) {
                System.out.println("Name: " + employee.getName() + " Age: " + employee.getAge());
            }

        }
       
        // This method calls the calculatePayroll method within Payroll for a set of 1 parameters
        public void calculateCompanyPayroll(List<OreillyEmployee> employeeList) {
            
            payroll.calculatePayroll(employeeList);
        }
        
        // This method calls the calculatePayroll method within Payroll for a set of 2 parameters
        public void calculateCompanyPayroll(List<OreillyEmployee> employeeList, String title) {
            
            payroll.calculatePayroll(employeeList, title);
        }
        
        // This method calls the giveAnnualRaiseForDepartment method within Payroll
        private void giveAnnualRaiseForDepartment(BigDecimal bigDecimal, List<OreillyEmployee> employeeList) {
            
            payroll.giveRasises(bigDecimal, employeeList);
        }

}
