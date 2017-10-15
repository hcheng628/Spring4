package us.supercheng.spring.spring4.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import us.supercheng.spring.spring4.springmvc.entity.Emp;
import us.supercheng.spring.spring4.springmvc.service.EmpService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/rest")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;


    @PostMapping("/addEmp")
    public String addEmp() {
        return "addEmp!";
    }

    @GetMapping("/getEmp/{id}")
    public String getEmp(@PathVariable String id) {
        return empService.getEmp(id);
    }

    @PutMapping("/updateEmp/{id}")
    public String updateEmp() {
        return "updateEmp!";
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
}