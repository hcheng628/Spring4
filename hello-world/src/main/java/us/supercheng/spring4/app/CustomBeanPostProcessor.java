package us.supercheng.spring4.app;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import us.supercheng.spring4.postbeanprocessor.entity.Sport;

public class CustomBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization");
		Sport forcedSport = new Sport();
		forcedSport.setName("Ping-Pong");
		return forcedSport;
	}
}