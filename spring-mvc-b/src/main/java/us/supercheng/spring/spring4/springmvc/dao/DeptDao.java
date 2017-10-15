package us.supercheng.spring.spring4.springmvc.dao;

import org.springframework.stereotype.Component;
import us.supercheng.spring.spring4.springmvc.entity.Dept;
import us.supercheng.spring.spring4.springmvc.entity.Emp;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeptDao {

    private List<Dept> deptList;

    public DeptDao() {
        super();
        deptList = new ArrayList<Dept>();
        this.init();
    }

    private void init() {
        this.deptList.add(new Dept("1", "Business Unit"));
        this.deptList.add(new Dept("2", "IT"));
        this.deptList.add(new Dept("3", "Hosting Services"));
        this.deptList.add(new Dept("4", "HR"));
        this.deptList.add(new Dept("5", "Accounting"));
        this.deptList.add(new Dept("6","Marketing"));
        this.deptList.add(new Dept("7", "Delivery"));
    }

    public List<Dept> getAllDept() {
        return this.deptList;
    }
}