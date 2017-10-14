package us.supercheng.spring.spring4.springmvc.entity;

public class Dept {
    private String deptId;
    private String deptName;

    public Dept() {
        super();
    }

    public Dept(String deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}