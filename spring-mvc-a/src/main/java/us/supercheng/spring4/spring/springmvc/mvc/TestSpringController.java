package us.supercheng.spring4.spring.springmvc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by supercheng on 9/25/17.
 */

@Controller
public class TestSpringController {

    @RequestMapping("serverStatus")
    public String checkServerStatus(){
        System.out.println("Server is Up & Running");
        return "success";
    }
}
