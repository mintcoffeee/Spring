package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
//공통 관심 사항(공통 코드) 
public class LoggingAdvice {
	@Before("execution(public void sample01.MessageBeanImpl.*Before())")
	public void beforeTrace() {
		System.out.println("before trace");
	}
	@After("execution(public * *.*.*After())")
	public void afterTrace() {
		System.out.println("After trace");
	}
	@Around("execution(public * *.MessageBeanImpl.*Print(..))")
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//앞에 삽입될 코드
		//System.out.println("하늘");
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("메소드 = " + methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		Object ob = joinPoint.proceed(); //핵심 코드 호출
		System.out.println(ob);
		
		//뒤에 삽입될 코드
		//System.out.println("땅");
		sw.stop();
		System.out.println("처리 시간 = " + sw.getTotalTimeMillis()/1000 + "초");
	}
}
