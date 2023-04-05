package sample01;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {
	@NonNull //바로 밑 line 에만 @NonNull이 먹힌다. 
	private String fruit;
	@Setter
	private int cost, qty;
	
	//fruit 생성자 이용해서 데이터 받기
	//Constructor Injection
//	public MessageBeanImp(String fruit) {
//		this.fruit = fruit;
//	}
	
	
	//cost, qty setter 이용해서 데이터 받기 
	//Setter Injection
//	public void setCost(int cost) {
//		this.cost = cost;
//	}
//	
//	public void setQty(int qty) {
//		this.qty = qty;
//	}
	
	
	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
	}

}
