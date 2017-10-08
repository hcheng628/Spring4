package us.supercheng.spring4.spring.springmvc.view;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Component
public class CustomView implements View {

    public String getContentType() {
        return "text/html";
    }

    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().print("This is a Custom View and Current Time: " + new Date());
    }
}
