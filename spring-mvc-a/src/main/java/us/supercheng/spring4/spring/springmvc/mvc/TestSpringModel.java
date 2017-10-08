package us.supercheng.spring4.spring.springmvc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import us.supercheng.spring4.spring.springmvc.entity.Pet;

import java.util.Date;
import java.util.Map;

// Once defined but not found -> Exception
@SessionAttributes(names = {"coffee", "java"}, types = {Pet.class, Integer.class})
@Controller
@RequestMapping("/apis")
public class TestSpringModel {

    @ModelAttribute("coffee")
    public String modelAttribute(Model model) {
        System.out.println("modelAttribute Method Triggered!" );
        // Uncomment line below to avoid doHttpSessionRequiredException Method RunTimeException
        // model.addAttribute("java","Java without Spring is nothing");
        return "illy";
    }


    @RequestMapping("/doSpringModelAndView")
    public ModelAndView doSpringModelAndView(ModelAndView mv){
        mv.getModel().put("name", "SuperMan");
        mv.setViewName("model-success");
        return mv;
    }

    @RequestMapping("/doSpringMap")
    public String doSpringMap(Map<String, Object> map) {
        map.put("current_time", new Date());
        return "model-success";
    }

    @RequestMapping("/doSpringSessionAttr")
    public String doSpringSessionAttr(Model model) {
        Pet pet = new Pet();
        pet.setKind("Dog");
        pet.setSex("Both");
        model.addAttribute("pet", pet);
        return "model-success";
    }

    @RequestMapping("/doHttpSessionRequiredException")
    public String doHttpSessionRequiredException(@ModelAttribute("java") String java) {
        System.out.println("doHttpSessionRequiredException: " + java);
        return "model-success";
    }

    @RequestMapping("/chicco")
    public String findWebLogicArgChicco(Model model) {
        String chiccoValue = System.getProperty("cfj.chicco.prop");
        System.out.println("Chicco Value: " + chiccoValue);
        System.out.println("Mr. " + System.getProperty("name"));
        model.addAttribute("chicco", chiccoValue);
        return "model-success";
    }
}
