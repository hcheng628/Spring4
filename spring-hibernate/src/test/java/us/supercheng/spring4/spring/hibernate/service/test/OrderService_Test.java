package us.supercheng.spring4.spring.hibernate.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.spring.hibernate.service.impl.CustomerServiceImpl;
import us.supercheng.spring4.spring.hibernate.service.impl.OrderServiceImpl;

public class OrderService_Test {
    private ApplicationContext applicationContext;
    private OrderServiceImpl orderService;

    {
        this.applicationContext = new ClassPathXmlApplicationContext("Spring-AoP-Config.xml");
        this.orderService = this.applicationContext.getBean(OrderServiceImpl.class);
    }

    @Test
    public void a_buyBooks_Service_Test () {
        this.orderService.buyBooksService(2, "isbn-test-abc-123", 3);
    }
}