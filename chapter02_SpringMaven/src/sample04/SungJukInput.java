package sample04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	@Autowired
	private SungJukDTO2 sungJukDTO2=null; //SungJukDTO2 타입을 찾아서 자동으로 매핑해라 
	@Autowired
	@Qualifier("arrayList")
	//Qualifier : List는 인터페이스로 많은 자식을 갖고 있기 때문에 어떤 자식이올지(어떤 타입의 Bean 값이 올지) 명시해주어야 한다.
	private List<SungJukDTO2> list=null;
	//private ArrayList<SungJukDTO2> list = null;
	
	@Override
	public void execute() {
		Scanner scan  = new Scanner(System.in);
		
		//DATA
		System.out.print("이   름 입력 : ");
		String name =scan.next();
		
		System.out.print("국어점수 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학점수 입력 : ");
		int math = scan.nextInt();
		System.out.println();
		
		int tot = kor + eng + math;
		double avg = tot / 3. ;
		
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(tot);
		sungJukDTO2.setAvg(avg);
		
		//ArrayList에 담기
		list.add(sungJukDTO2);
		
		//출력 
		System.out.println(name+"님의 데이터를 입력 하였습니다");
		
	}

}
