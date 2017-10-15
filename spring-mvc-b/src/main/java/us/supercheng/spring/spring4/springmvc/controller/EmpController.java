package us.supercheng.spring.spring4.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import us.supercheng.spring.spring4.springmvc.entity.Dept;
import us.supercheng.spring.spring4.springmvc.entity.Emp;
import us.supercheng.spring.spring4.springmvc.service.DeptService;
import us.supercheng.spring.spring4.springmvc.service.EmpService;

@RequestMapping("/api/rest")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;


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
        return empService.getEmp(id);
    }

    //@PutMapping("/updateEmp")
    @RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
    public ModelAndView updateEmp(Emp emp) {
        this.empService.updateEmp(emp);
        return new ModelAndView("redirect:/api/rest/getEmps");
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
}