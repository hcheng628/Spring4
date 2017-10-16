package us.supercheng.spring.spring4.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import us.supercheng.spring.spring4.springmvc.entity.Dept;
import us.supercheng.spring.spring4.springmvc.entity.Emp;
import us.supercheng.spring.spring4.springmvc.service.DeptService;
import us.supercheng.spring.spring4.springmvc.service.EmpService;
import java.util.Map;

@RequestMapping("/api/rest")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

    @ModelAttribute
    public void getEmp(@RequestParam(value = "id", required = false) Integer id,
                       Map<String, Object> map) {
        System.out.println("ModelAttribute Triggered");
        if(id != null) {
            map.put("emp", this.empService.getEmp(id+""));
        }
    }


    //@PostMapping("/addEmp")
    @RequestMapping(value = "/addEmp", method = RequestMethod.POST)
    public ModelAndView addEmp(Emp emp) {
        for (Dept eachDept : this.deptService.getAllDepts()) {
            if (emp.getEmpDept().getDeptId().equalsIgnoreCase(eachDept.getDeptId())) {
                emp.getEmpDept().setDeptName(eachDept.getDeptName());
            }
        }
        emp.setId(this.empService.getEmps().size() + 1 + "");   // In reality this will be generate by DB
        this.empService.addEmp(emp);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("empList", this.empService.getEmps());
        modelAndView.setViewName("redirect:/api/rest/getEmps");
        return modelAndView;
    }

    @GetMapping("/getEmp/{id}")
    public String getEmp(@PathVariable String id) {
        return empService.getEmpJSON(id);
    }

    /*
        Emp as InputPara works for POST not PUT ;-(
     */

    //@PutMapping("/updateEmp/{id}")
    @RequestMapping(value = "/updateEmp/{id}", method = RequestMethod.PUT)
    public String updateEmp(@PathVariable("id") String id,
                            @RequestBody MultiValueMap<String, String> body) {
        Dept updateDept = null;
        for (Dept each : this.deptService.getAllDepts()) {
            if ( each.getDeptId().equalsIgnoreCase(body.getFirst("empDept.deptId"))) {
                updateDept = each;
            }
        }
        Emp updateEmp = new Emp(id, body.getFirst("firstName"),body.getFirst("lastName"),
                body.getFirst("email"), Integer.parseInt(body.getFirst("gender")), updateDept);
        System.out.println("Update Controller: " + updateEmp);
        return this.empService.updateEmp(updateEmp);
    }

    @DeleteMapping("/delEmp/{id}")
    public String delEmp(@PathVariable String id) {
        return this.empService.delEmp(id);
    }

    @RequestMapping("/getEmps")
    public ModelAndView getEmps(ModelAndView modelAndView) {
        modelAndView.addObject("empList", this.empService.getEmps());
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("/createEmp")
    public ModelAndView createEmp(ModelAndView modelAndView) {
        modelAndView.addObject("depts", this.deptService.getAllDepts());
        modelAndView.addObject("emp", new Emp());
        modelAndView.setViewName("emp");
        return modelAndView;
    }

    @RequestMapping(value = "/updateEmp/{id}", method = RequestMethod.GET)
    public ModelAndView editEmp(@PathVariable("id") String empId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("depts", this.deptService.getAllDepts());
        Emp emp = this.empService.getEmp(empId);
        System.out.println("Update: " + emp);
        modelAndView.addObject("emp", emp);
        modelAndView.setViewName("emp");
        return modelAndView;
    }
}