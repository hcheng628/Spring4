package us.supercheng.spring.spring4.springmvc.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class Emp {
    private String id;
    private String firstName;
    private String lastName;

    @Email
    @NotEmpty
    private String email;

    @Max(1)
    @Min(0)
    private Integer gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date dob;

    @NumberFormat(pattern = "#,###,###.##")
    private Double salary;

    private Dept empDept;

    public Emp() {
        super();
    }

    public Emp(String id, String firstName, String lastName, String email, Integer gender, Dept empDept) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.empDept = empDept;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public Dept getEmpDept() {
        return empDept;
    }
    public void setEmpDept(Dept empDept) {
        this.empDept = empDept;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", salary=" + salary +
                ", empDept=" + empDept +
                '}';
    }
}