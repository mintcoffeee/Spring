package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;

//@Configuration: xml 처럼 bean을 설정할 수 있는 환경 설정 파일 
@Configuration
public class SpringConfiguration {
	
	//smaple01
	@Bean
	public MessageBeanImpl messageBeanImpl(){
		return new MessageBeanImpl("사과");
	}
	
	//smaple02
	@Bean
	public CalcAdd calcAdd(){
		return new CalcAdd(25, 36);
	}
//	@Bean
//	public CalcMul calcMul(){
//		return new CalcMul();
//	}
	@Bean(name="calcMul")
	public CalcMul getCalcMul(){
		return new CalcMul();
	}
}



/*
@Bean
-메소드에서 return 되는 값을 빈으로 생성해준다.
-메소드의 이름은 반드시 빈의 id명으로 만들어야 한다.
*/