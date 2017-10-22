package us.supercheng.spring.spring4.springmvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import us.supercheng.spring.spring4.springmvc.service.EmpConversionService;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "us.supercheng.spring.spring4.springmvc")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver setInternalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean(name = "objectMapperJSON")
    public ObjectMapper getObjectMapperJSON() {
        return new ObjectMapper();
    }

//    @Bean(name = "conversionService")
//    public ConversionServiceFactoryBean getEmpCustomConverter() {
//        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
//        Set<EmpConversionService> empConversionServiceSet = new HashSet<>();
//        empConversionServiceSet.add(new EmpConversionService());
//        conversionServiceFactoryBean.setConverters(empConversionServiceSet);
//        return conversionServiceFactoryBean;
//    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new EmpConversionService());
    }
}