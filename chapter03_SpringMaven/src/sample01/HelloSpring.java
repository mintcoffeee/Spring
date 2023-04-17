package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("acQuickStart.xml");
		MessageBean messageBean = (MessageBean) context.getBean("messageBeanImpl");
		
		//Before
		/*
		messageBean.shwoPrintBefore();
		System.out.println();
		messageBean.viewPrintBefore();
		System.out.println();
		messageBean.display();
		 
		 */
		
		//After
		/*
		messageBean.shwoPrintAfter();
		System.out.println();
		messageBean.viewPrintAfter();
		System.out.println();
		messageBean.display();
		*/
		
		//Around
		messageBean.shwoPrint();
		System.out.println();
		messageBean.viewPrint();
		System.out.println();
		messageBean.display();
	}
}
