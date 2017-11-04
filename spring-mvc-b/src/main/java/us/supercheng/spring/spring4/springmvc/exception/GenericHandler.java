package us.supercheng.spring.spring4.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GenericHandler {
    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", ex);
        mv.setViewName("error");
        return mv;
    }
}