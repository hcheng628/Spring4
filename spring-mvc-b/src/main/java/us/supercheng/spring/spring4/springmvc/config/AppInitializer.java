package us.supercheng.spring.spring4.springmvc.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        System.out.println("Custom Filter Init");
        servletContext.setInitParameter("javax.servlet.jsp.jstl.fmt.localizationContext",
              "i18n");
        servletContext.addFilter("HiddenHttpMethodFilter", HiddenHttpMethodFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");
    }
}
