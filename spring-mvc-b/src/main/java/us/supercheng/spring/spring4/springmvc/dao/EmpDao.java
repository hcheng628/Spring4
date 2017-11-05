package us.supercheng.spring.spring4.springmvc.dao;

import org.springframework.stereotype.Component;
import us.supercheng.spring.spring4.springmvc.entity.Dept;
import us.supercheng.spring.spring4.springmvc.entity.Emp;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmpDao {

    List<Emp> empList;

    public EmpDao() {
        super();
        System.out.println("Init EmpDao");
        this.empList = new ArrayList<Emp>();
        this.init();    // No Real DB + Just a Simulation
    }

    public List<Emp> getEmpList() {
        return empList;
    }
    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    private void init () {
        this.empList.add(new Emp("1", "Vittorio", "Rich", "V@gmail.com",1,new Dept("1", "Business Unit")));
        this.empList.add(new Emp("2", "Chicco", "Jared", "fdawsf@gmail.com",1,new Dept("2", "IT")));
        this.empList.add(new Emp("3", "Recardo", "Keeper", "32121fda@gmail.com",1,new Dept("3", "Hosting Services")));
        this.empList.add(new Emp("4", "Leo", "Koz", "twradf@gmail.com",1,new Dept("4", "HR")));
        this.empList.add(new Emp("5", "John", "Dendi", "321fda@gmail.com",1,new Dept("5", "Accounting")));
        this.empList.add(new Emp("6", "Redding", "Chris", "fdsa@gmail.com",1,new Dept("6","Marketing")));
        this.empList.add(new Emp("7", "Raji", "Close", "321@gmail.com",1,new Dept("7", "Delivery")));
        this.empList.add(new Emp("8", "Rev", "Doug", "321@gmail.com",1,new Dept("5","Accounting")));
        this.empList.add(new Emp("9", "Tiziano", "James", "413@gmail.com",1,new Dept("3","Housting Service")));
        this.empList.add(new Emp("10", "Andrey", "Brooks", "fda@gmail.com",1,new Dept("2", "IT")));
    }

    public String addEmpDao(Emp newEmp) {
        this.empList.add(newEmp);
        return newEmp.getId();
    }

    public Emp getEmpDao(String empId) {
        for (Emp each : this.empList) {
            if(each.getId().equalsIgnoreCase(empId)) {
                return each;
            }
        }
        return null;
    }

    public String updateEmpDao(Emp updateEmp) {
        for (Emp each : this.empList) {
            if(updateEmp.getId().equalsIgnoreCase(each.getId())) {
                this.empList.remove(each);
                this.empList.add(updateEmp);
                return updateEmp.getId();
            }
        }
        return null;
    }

    public String delEmpDao(String empId) {
        for (Emp each : this.empList) {
            if(each.getId().equalsIgnoreCase(empId)) {
                this.empList.remove(each);
                System.out.println("Emp List Size: " + this.empList.size());
                return each.getId();
            }
        }
        return null;
    }

    public List<Emp> getEmpListDao() {
        return this.empList;
    }
}