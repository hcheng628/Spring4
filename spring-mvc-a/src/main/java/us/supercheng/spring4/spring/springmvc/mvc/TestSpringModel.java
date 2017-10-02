package us.supercheng.spring4.spring.springmvc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/apis")
public class TestSpringModel {

    @RequestMapping("/doSpringModelAndView")
    public ModelAndView doSpringModelAndView(ModelAndView mv){
        mv.getModel().put("name", "Cheng");
        mv.setViewName("model-success");
        return mv;
    }
}
