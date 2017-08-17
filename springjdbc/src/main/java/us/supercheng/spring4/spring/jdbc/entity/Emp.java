package us.supercheng.spring4.spring.jdbc.entity;

import org.springframework.stereotype.Component;

@Component
public class Emp {
    private String fullName;
    private Integer id;
    private Integer age;
    private Integer deptId;

    public Emp() {
        super();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "fullName='" + fullName + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", deptId=" + deptId +
                '}';
    }
}