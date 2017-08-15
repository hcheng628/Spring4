package us.supercheng.spring4.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.supercheng.spring4.entity.Car;
import us.supercheng.spring4.entity.DataSource;
import us.supercheng.spring4.entity.ParkingLot;
import us.supercheng.spring4.entity.Person;
import us.supercheng.spring4.entity.RaceGame;

public class App {

	private static final String SPRING_BEAN_IOC_FILE = "SpringBeanDef.xml";
	
	public static void main(String[]  args) {
		Person person = new Person();
		person.setName("Regular");
		person.justSayHi();	
		// 1 Init IOC
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);
		// 2 Get Person Instance from IOC
		Person personSpring = (Person) appContext.getBean("person");
		personSpring.justSayHi();
		
		Car car1 = (Car) appContext.getBean("car1");
		Car car2 = (Car) appContext.getBean("car2");
		
		System.out.println(car1);
		System.out.println(car2);
		
		ParkingLot parkinglot1 = (ParkingLot) appContext.getBean("parkinglot1");
		System.out.println(parkinglot1);
		
		RaceGame raceGame = (RaceGame) appContext.getBean(RaceGame.class);
		System.out.println(raceGame);
		
		DataSource dataSource = (DataSource) appContext.getBean(DataSource.class);
		System.out.println(dataSource);
		
	}
}