package us.supercheng.spring.spring4.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring.spring4.springmvc.dao.EmpDao;
import us.supercheng.spring.spring4.springmvc.entity.Emp;

@Service
public class EmpService {

    @Autowired
    private EmpDao empDao;



    public EmpService() {
        super();
    }

    public String addEmp(Emp newEmp) {
        return this.empDao.addEmpDao(newEmp);
    }

    public Emp getEmp(String empId) {
        return this.empDao.getEmpDao(empId);
    }

    public String updateEmp(Emp updateEmp) {
        return this.empDao.updateEmpDao(updateEmp);
    }

    public String delEmp(String empId) {
        return this.empDao.delEmpDao(empId);
    }

}
