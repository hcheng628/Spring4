package us.supercheng.spring4.spring.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.spring.jdbc.dao.EmpDao;

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
}