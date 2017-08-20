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
        String q = "USE I; INSERT INTO Emp " +
                "(fullname, id, age, deptId) VALUES ( :fullname, :id, :age, :deptId)";
        Map<String, Object> inParamMap = new HashMap<String, Object>();

        inParamMap.put("fullname", emp.getFullName());
        inParamMap.put("id", emp.getId());
        inParamMap.put("age", emp.getAge());
        inParamMap.put("deptId", emp.getDeptId());

        return this.namedParameterJdbcTemplate.update(q,inParamMap);
    }

    public Emp getEmp(int inId) {
        String q = "SELECT * FROM Emp WHERE id = :id;";
        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("id", inId);

        List<Emp> temp = this.namedParameterJdbcTemplate.query(q, inParamMap, new RowMapper<Emp>() {
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                emp.setAge(resultSet.getInt("age"));
                emp.setDeptId(resultSet.getInt("deptId"));
                emp.setFullName(resultSet.getString("fullname"));
                emp.setId(resultSet.getInt("id"));
                return emp;
            }
        });

        return temp.get(0);
    }

    public String updateEmp() {
        String q = "UPDATE Emp SET fullname = ?, age = ?,  deptId = ? WHERE id = ?;";

        return null;
    }

    public String delEmp() {
        String q = "DELETE FROM Emp WHERE id = ?;";

        return null;
    }
}