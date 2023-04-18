package sample01;

import lombok.Setter;

@Setter
public class MessageBeanImpl implements MessageBean {
			//target

	private String str;

	//joinPoint: 모든 메소드  
	//pointCut: 공통 메소드 적용대상 
	@Override
	public void shwoPrintBefore() {
		System.out.println("before trace");
		System.out.println("showPrintBefore 메세지 = " + str);//핵심코드 
	}
	
	//pointCut
	@Override
	public void viewPrintBefore() {
		System.out.println("before trace");
		try {
			Thread.sleep(1000);//1초 - 단위 1/1000초
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("viewPrintBefore 메세지 = " + str);//핵심 코드 
	}

	@Override
	public void shwoPrintAfter() {
		System.out.println("after trace");
		System.out.println("shwoPrintAfter 메세지 = " + str);//핵심코드
	}

	@Override
	public void viewPrintAfter() {
		System.out.println("after trace");
		try {
			Thread.sleep(1000);//1초 - 단위 1/1000초
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("viewPrintAfter 메세지 = " + str);//핵심 코드
	}
	

	@Override
	public String shwoPrint() {
		System.out.println("shwoPrint 메세지 = " + str);//핵심코드
		return "스프링";
	}

	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000);//1초 - 단위 1/1000초
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("viewPrint 메세지 = " + str);//핵심 코드
	}
	
	@Override
	public void display() {
		System.out.println("display 메세지 = " + str);//핵심코드
	}

}
