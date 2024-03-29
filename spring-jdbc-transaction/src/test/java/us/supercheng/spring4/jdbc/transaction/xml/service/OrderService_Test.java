package us.supercheng.spring4.jdbc.transaction.xml.service;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.jdbc.transaction.xml.service.impl.OrderServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderService_Test {

    ApplicationContext appContext;
    OrderServiceImpl orderService;

    @Before
    public void warmUp() {
        this.appContext = new ClassPathXmlApplicationContext("Spring-IoC-XML-Config.xml");
        this.orderService = (OrderServiceImpl) this.appContext.getBean("orderService");
    }

    @Test
    public void a_buyBooks_Service_Test() {
        this.orderService.buyBooksService(1,"cba-123-321-def",4);
    }
}