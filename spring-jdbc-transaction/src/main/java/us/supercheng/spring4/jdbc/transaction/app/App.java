package us.supercheng.spring4.jdbc.transaction.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import us.supercheng.spring4.jdbc.transaction.service.OrderServiceImpl;

public class App {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-IoC-Config.xml");
        OrderServiceImpl orderService = (OrderServiceImpl) appContext.getBean("orderServiceImpl");
    }
}