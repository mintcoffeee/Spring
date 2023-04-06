package sample03;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SungJukDTO {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	
	@Override
	public String toString() {
		return name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+tot+"\t"+String.format("%.3f",avg);
	}
}
