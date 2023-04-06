package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class CalcMul implements Calc {
	private int x, y;
	
	//생성자는 자동으로 호출하기 때문에 자동으로 처리된다. 
	//setter는 생성자가 아니기 때문에 직접 읽어오도록 지시를 해주어야 한다. -> @Autowired
	@Autowired
	public void setX(@Value("25") int x) {
		this.x = x;
	}
	@Autowired
	public void setY(@Value("36") int y) {
		this.y = y;
	}

	@Override
	public void calculate() {
		System.out.println(x+" * "+y+" = "+x*y);
	}

}
