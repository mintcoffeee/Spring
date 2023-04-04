package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//Java: new 객체 생성 
		//Spring: applicationContex.xml 에서 bean 생성 
		 ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");		
		
	}

}
