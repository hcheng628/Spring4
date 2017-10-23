package us.supercheng.spring.spring4.springmvc.locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import us.supercheng.spring.spring4.springmvc.config.AppConfig;

import java.util.Locale;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class Main_Test {

    @Autowired
    ResourceBundleMessageSource resourceBundleMessageSource;

    @Test
    public void a_zh_locale_test() {
        String emailMsg = resourceBundleMessageSource.getMessage("Email.employee.email",
                null, "Default", new Locale("ZH"));
        System.out.println(emailMsg);
    }

    @Test
    public void a_en_locale_test() {
        String emailMsg = resourceBundleMessageSource.getMessage("Email.employee.email",
                null, "Default", new Locale("EN"));
        System.out.println(emailMsg);
    }

}