package us.supercheng.spring.spring4.springmvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import us.supercheng.spring.spring4.springmvc.interceptor.CustomHttpInterceptor;
import us.supercheng.spring.spring4.springmvc.interceptor.FirstInterceptor;
import us.supercheng.spring.spring4.springmvc.interceptor.SecondInterceptor;
import us.supercheng.spring.spring4.springmvc.interceptor.ThirdInterceptor;
import us.supercheng.spring.spring4.springmvc.service.EmpConversionService;
import java.util.Locale;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "us.supercheng.spring.spring4.springmvc",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = RestController.class))
public class AppConfig extends WebMvcConfigurerAdapter {
    private LocalValidatorFactoryBean localValidatorFactoryBean;
    public void setLocalValidatorFactoryBean(LocalValidatorFactoryBean localValidatorFactoryBean) {
        this.localValidatorFactoryBean = localValidatorFactoryBean;
    }
    public LocalValidatorFactoryBean getLocalValidatorFactoryBean(LocalValidatorFactoryBean localValidatorFactoryBean) {
        return this.localValidatorFactoryBean;
    }

    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties exceptionProps = new Properties();
        exceptionProps.setProperty("java.lang.ArrayIndexOutOfBoundsException", "error");
        resolver.setExceptionAttribute("errorMsg");
        resolver.setExceptionMappings(exceptionProps);
        return resolver;
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

    @Bean("localeResolver")
    public CookieLocaleResolver getSessionLocaleResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        localeResolver.setCookieName("my-locale-cookie");
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;
//        SessionLocaleResolver slr = new SessionLocaleResolver();
//        slr.setDefaultLocale(Locale.US);
//        return slr;
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(new Locale("cn"));
//        return sessionLocaleResolver;
    }

    @Bean("messageSource")
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

    @Bean("localeChangeInterceptor")
    public LocaleChangeInterceptor getLocaleChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLocaleChangeInterceptor());
        CustomHttpInterceptor customHttpInterceptor = new CustomHttpInterceptor();
        FirstInterceptor firstInterceptor = new FirstInterceptor();
        SecondInterceptor secondInterceptor = new SecondInterceptor();
        ThirdInterceptor thirdInterceptor = new ThirdInterceptor();
        registry.addInterceptor(customHttpInterceptor).addPathPatterns("/api/rest/test/*");
        registry.addInterceptor(firstInterceptor).addPathPatterns().addPathPatterns("/api/rest/test/*");
        registry.addInterceptor(secondInterceptor).addPathPatterns().addPathPatterns("/api/rest/test/*");
        registry.addInterceptor(thirdInterceptor).addPathPatterns().addPathPatterns("/api/rest/test/*");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new EmpConversionService());
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource(getMessageSource());
        return validatorFactoryBean;
    }
}