/*
 * This class is used to create our employee object
 * 
 */

package com.oreillyauto.w0501;

import java.io.Serializable;
import java.math.BigDecimal;

public class OreillyEmployee implements Serializable{

        private static final long serialVersionUID = 21332351078239498L;
        
        private int id;
        private int age;
        private String name;
        private BigDecimal salary;
        private String title;
        
        public OreillyEmployee() {
            
        }
        
        public OreillyEmployee(int id, int age, String name, BigDecimal salary, String title) {
            
            this.id = id;
            this.age = age;
            this.name = name;
            this.salary = salary;
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((salary == null) ? 0 : salary.hashCode());
            result = prime * result + ((title == null) ? 0 : title.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            OreillyEmployee other = (OreillyEmployee) obj;
            if (age != other.age)
                return false;
            if (id != other.id)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (salary == null) {
                if (other.salary != null)
                    return false;
            } else if (!salary.equals(other.salary))
                return false;
            if (title == null) {
                if (other.title != null)
                    return false;
            } else if (!title.equals(other.title))
                return false;
            return true;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "OreillyEmployee [id=" + id + ", age=" + age + ", name=" + name + ", salary=" + salary + ", title=" + title + "]";
        }
        
        
}
