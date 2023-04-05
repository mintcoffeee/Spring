package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//web.xml 만 자동으로 읽음
		//다른 xml파일은 직접 읽어야 한다.
		
		//Java: new 객체 생성 
		//Spring: applicationContex.xml 에서 bean 생성 
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");		
		MessageBean messageBean = (MessageBean)context.getBean("messageBean"); //부모 = 자식
		messageBean.sayHello("Spring");
		
		MessageBean messageBean2 = (MessageBean)context.getBean("messageBean", MessageBean.class); //부모 = 자식
		messageBean2.sayHello("Spring");
		
		MessageBean messageBean3 = (MessageBean)context.getBean("messageBean"); //부모 = 자식
		messageBean3.sayHello("Spring");
		
		
	}

}
