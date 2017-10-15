package us.supercheng.spring.spring4.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring.spring4.springmvc.dao.DeptDao;
import us.supercheng.spring.spring4.springmvc.entity.Dept;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptDao deptDao;

    public List<Dept> getAllDepts() {
        return this.deptDao.getAllDept();
    }
}
