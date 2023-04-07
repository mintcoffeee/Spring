package sample04;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukUpdate implements SungJuk {
	private List<SungJukDTO2> list;
	
//	public void setList(List<SungJukDTO2> list) {
//		this.list = list;
//	}

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();
		
		int sw=0;
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equalsIgnoreCase(name)) {
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");	
				System.out.println(sungJukDTO2);
				System.out.println();
				
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
				
				//출력 
				System.out.println(name+"님의 데이터를 수정하였습니다");
				
				sw=1;
				break;
			}//if
		}//for
		if(sw==0) System.out.println("찾고자하는 이름이 없습니다");
	}

}
