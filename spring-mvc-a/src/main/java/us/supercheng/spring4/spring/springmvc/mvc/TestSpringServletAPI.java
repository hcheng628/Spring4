package us.supercheng.spring4.spring.springmvc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/apis")
public class TestSpringServletAPI {

    @RequestMapping("/doServletAPI")
    public void doServletRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("doServletRequest.....");
        try {
            response.getWriter().write("This is SpringMVC Request Mapping with Servlet API :-)");
        } catch (Exception ex){}
    }

}
