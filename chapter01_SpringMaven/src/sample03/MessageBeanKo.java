package sample03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//bean 생성 어노테이션, xml안의 bean이 필요 없어진다. 
@Component("messageBean") //bean id 명 
@Scope("prototype")
public class MessageBeanKo implements MessageBean {
	private int num; //필드, 초기화=0
	
	public MessageBeanKo() {
		System.out.println("MessageBeanKo 기본 생성자");
	}
	
	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num =  " + num);
		System.out.println("안녕하세요 " + name);
		System.out.println();
	}

}
