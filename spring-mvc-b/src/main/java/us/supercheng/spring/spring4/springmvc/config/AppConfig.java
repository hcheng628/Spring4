package us.supercheng.spring.spring4.springmvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import us.supercheng.spring.spring4.springmvc.interceptor.CustomHttpInterceptor;
import us.supercheng.spring.spring4.springmvc.interceptor.FirstInterceptor;
import us.supercheng.spring.spring4.springmvc.interceptor.SecondInterceptor;
import us.supercheng.spring.spring4.springmvc.interceptor.ThirdInterceptor;
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

    @Bean
    public ResourceBundleMessageSource getMessageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("i18n");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }

    @Bean("multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        return commonsMultipartResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new EmpConversionService());
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource((MessageSource) getMessageSource());
        return validatorFactoryBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("localeCode");
        registry.addInterceptor(localeChangeInterceptor);

        CustomHttpInterceptor customHttpInterceptor = new CustomHttpInterceptor();
        registry.addInterceptor(customHttpInterceptor).addPathPatterns("/api/rest/test/*");

        FirstInterceptor firstInterceptor = new FirstInterceptor();
        SecondInterceptor secondInterceptor = new SecondInterceptor();
        ThirdInterceptor thirdInterceptor = new ThirdInterceptor();

        registry.addInterceptor(firstInterceptor).addPathPatterns().addPathPatterns("/api/rest/test/*");
        registry.addInterceptor(secondInterceptor).addPathPatterns().addPathPatterns("/api/rest/test/*");
        registry.addInterceptor(thirdInterceptor).addPathPatterns().addPathPatterns("/api/rest/test/*");

    }
}