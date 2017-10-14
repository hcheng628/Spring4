package us.supercheng.spring.spring4.springmvc.entity;

public class Emp {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer gender;
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

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", empDept=" + empDept +
                '}';
    }
}