package us.supercheng.spring4.spring.springmvc.entity;

public class Pet {
    private String kind;
    private String sex;

    public Pet() {
        super();
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "kind='" + kind + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
