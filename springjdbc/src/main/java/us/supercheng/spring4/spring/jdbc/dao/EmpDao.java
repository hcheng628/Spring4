package us.supercheng.spring4.spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import us.supercheng.spring4.spring.jdbc.entity.Emp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmpDao {

    private final String Emp_Create_Query = "INSERT INTO Emp (fullname, id, age, deptId) VALUES ( :fullname, :id, :age, :deptId)";
    private final String Emp_Retrieve_Query = "SELECT * FROM Emp WHERE id = :id;";
    private final String Emp_Retrieve_Query_By_DeptId = "SELECT * FROM Emp WHERE deptId = :deptId;";

    private final String Emp_Update_Query = "UPDATE Emp SET fullname = :fullname, age = :age,  deptId = :deptId WHERE id = :id;";
    private final String  Emp_Delete_Query = "DELETE FROM Emp WHERE id = :id;";



    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EmpDao () {
        super();
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public int addEmp(Emp emp) {
        return this.namedParameterJdbcTemplate.update(Emp_Create_Query,this.setEmpParams(emp));
    }

    public Emp getEmp(int inId) {
        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("id", inId);
        List<Emp> temp = this.namedParameterJdbcTemplate.query(Emp_Retrieve_Query, inParamMap, new Emp());
        return temp.get(0);
    }

    public List<Emp> getEmpListByDeptId(int inDeptId) {
        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("deptId", inDeptId);
        return this.namedParameterJdbcTemplate.query(Emp_Retrieve_Query_By_DeptId, inParamMap, new Emp());
    }


    public int updateEmp(Emp inEmp) {
        return this.namedParameterJdbcTemplate.update(Emp_Update_Query, this.setEmpParams(inEmp));
    }

    public int delEmp(int inId) {
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("id", inId);
        return this.namedParameterJdbcTemplate.update(Emp_Delete_Query, params);
    }

    public int[] addEmpBatch(List<Emp> inEmpList) {
        Map<String, Object>[] paramList = new HashMap[inEmpList.size()];
        for (int i=0;i<inEmpList.size();i++) {
            paramList[i] = this.setEmpParams(inEmpList.get(i));
        }
        return namedParameterJdbcTemplate.batchUpdate(Emp_Create_Query, paramList);
    }

    public int[] updateEmpBatch(List<Emp> inEmpList) {
        Map<String, Object>[] paramList = new HashMap[inEmpList.size()];
        for (int i=0;i<inEmpList.size();i++) {
            paramList[i] = this.setEmpParams(inEmpList.get(i));
        }
        return namedParameterJdbcTemplate.batchUpdate(Emp_Update_Query, paramList);
    }

    public int[] delEmpBatch(int [] inEmpIdList) {
        Map<String, Object>[] paramList = new HashMap[inEmpIdList.length];
        for (int i=0;i<inEmpIdList.length;i++) {
            Map<String, Object> eachIdParam = new HashMap<String, Object>();
            eachIdParam.put("id", inEmpIdList[i]);
            paramList[i] = eachIdParam;
        }
        return this.namedParameterJdbcTemplate.batchUpdate(Emp_Delete_Query, paramList);
    }

    private Map<String, Object> setEmpParams(Emp inEmp) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("fullname",inEmp.getFullName());
        params.put("id",inEmp.getId());
        params.put("age",inEmp.getAge());
        params.put("deptId",inEmp.getDeptId());
        return params;
    }
}