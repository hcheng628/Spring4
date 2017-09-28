package us.supercheng.spring4.spring.springmvc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by supercheng on 9/25/17.
 */

@Controller
@RequestMapping("/apis")
public class TestSpringController {

    @RequestMapping("/serverStatus")
    public String checkServerStatus(){
        System.out.println("GET Method: Server is Up & Running");
        return "success";
    }

    @RequestMapping(value = "/serverStatusPost", method = RequestMethod.POST)
    public String checkServerStatusPost(){
        System.out.println("POST Method: Server is Up & Running");
        return "success";
    }

    @RequestMapping(value = "/serverSampleHeader", headers = "Host=localhost:8080", method = RequestMethod.GET)
    public String checkServerSampleHeaderMethod(){
        System.out.println("POST Method: Server is Up & Running");
        return "success";
    }

    @RequestMapping(value = "/serverSampleParams", params = {"id=1", "name=test"}, method = RequestMethod.GET)
    public String checkServerSampleParamsMethod(){
        System.out.println("POST Method: Server is Up & Running");
        return "success";
    }
}