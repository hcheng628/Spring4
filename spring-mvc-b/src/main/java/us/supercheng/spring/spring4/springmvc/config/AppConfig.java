package us.supercheng.spring.spring4.springmvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
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

    private ResourceBundleMessageSource resourceBundleMessageSource;
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    public ResourceBundleMessageSource getResourceBundleMessageSource() {
        return resourceBundleMessageSource;
    }
    public void setResourceBundleMessageSource(ResourceBundleMessageSource resourceBundleMessageSource) {
        this.resourceBundleMessageSource = resourceBundleMessageSource;
    }
    public void setLocalValidatorFactoryBean(LocalValidatorFactoryBean localValidatorFactoryBean) {
        this.localValidatorFactoryBean = localValidatorFactoryBean;
    }
    public LocalValidatorFactoryBean getLocalValidatorFactoryBean(LocalValidatorFactoryBean localValidatorFactoryBean) {
        return this.localValidatorFactoryBean;
    }


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

//    @Bean
//    public ResourceBundleMessageSource getMessageSource(){
//        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
//        resourceBundleMessageSource.setBasename("i18n");
//        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
//        return resourceBundleMessageSource;
//    }

    @Bean
    public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource() {
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("classpath:i18n");
        return reloadableResourceBundleMessageSource;
    }

//    @Bean
//    public LocalValidatorFactoryBean getLocalValidatorFactoryBean() {
//        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
//        localValidatorFactoryBean.setValidationMessageSource(this.getReloadableResourceBundleMessageSource());
//        return localValidatorFactoryBean;
//    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new EmpConversionService());
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource((MessageSource) getReloadableResourceBundleMessageSource());
        return validatorFactoryBean;
    }
}