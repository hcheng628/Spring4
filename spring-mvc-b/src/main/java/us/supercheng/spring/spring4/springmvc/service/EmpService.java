package us.supercheng.spring.spring4.springmvc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import us.supercheng.spring.spring4.springmvc.dao.EmpDao;
import us.supercheng.spring.spring4.springmvc.entity.Emp;
import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpDao empDao;

    @Autowired
    @Qualifier("objectMapperJSON")
    private ObjectMapper objectMapperJSON;

    public EmpService() {
        super();
    }

    public String addEmp(Emp newEmp) {
        return this.empDao.addEmpDao(newEmp);
    }

    public String getEmp(String empId) {
        try {
            return this.objectMapperJSON.writeValueAsString(this.empDao.getEmpDao(empId));
        } catch (Exception ex) {
            return null;
        }
    }

    public String updateEmp(Emp updateEmp) {
        return this.empDao.updateEmpDao(updateEmp);
    }

    public String delEmp(String empId) {
        return this.empDao.delEmpDao(empId);
    }

    public List<Emp> getEmps() {
        return this.empDao.getEmpListDao();
    }
}
