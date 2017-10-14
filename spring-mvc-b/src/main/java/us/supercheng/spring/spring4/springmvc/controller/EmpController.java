package us.supercheng.spring.spring4.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.supercheng.spring.spring4.springmvc.service.EmpService;

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
    public String getEmp() {
        return "getEmp!";
    }

    @PutMapping("/updateEmp/{id}")
    public String updateEmp() {
        return "updateEmp!";
    }

    @DeleteMapping("/delEmp/{id}")
    public String delEmp() {
        return "delEmp!";
    }
}