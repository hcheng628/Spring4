package us.supercheng.spring4.spring.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.spring.jdbc.dao.EmpDao;
import us.supercheng.spring4.spring.jdbc.entity.Emp;
import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpDao empDao;

    EmpService () {
        super();
    }

    public EmpDao getEmpDao() {
        return empDao;
    }

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    public int addEmpService(Emp inEmp) {
        return this.empDao.addEmp(inEmp);
    }

    public Emp getEmpService(int inId) {
        return this.empDao.getEmp(inId);
    }

    public List<Emp> getEmpListByDeptIdService(int inDeptId) {
        return this.empDao.getEmpListByDeptId(inDeptId);
    }

    public int updateEmpService(Emp inEmp) {
        return this.empDao.updateEmp(inEmp);
    }

    public int deleteEmpService(int inId) {
        return this.empDao.delEmp(inId);
    }

    public int[] addEmpBatchService(List<Emp> inEmpList) {
        return this.empDao.addEmpBatch(inEmpList);
    }

    public int[] updateEmpBatchService(List<Emp> inEmpList) {
        return this.empDao.updateEmpBatch(inEmpList);
    }

    public int[] deleteEmpBatchService(int[] inEmpIdList) {
        return this.empDao.delEmpBatch(inEmpIdList);
    }
}