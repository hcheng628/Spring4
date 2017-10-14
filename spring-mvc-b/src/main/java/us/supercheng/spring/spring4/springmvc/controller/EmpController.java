package us.supercheng.spring.spring4.springmvc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

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