package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService2 implements UserService {
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.print("수정할 아이디 입력 : ");
		String id = scan.next();
		
		//DB
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("찾고자하는 아이디가 없습니다.");
			return;
		}
		
		System.out.println("이름\t아이디\t비밀번호\t");
		System.out.println(userDTO.getName() +"\t"+
							userDTO.getId() +"\t"+
							userDTO.getPwd());
		
		System.out.println();
		System.out.println("수정할 이름 입력 : ");
		String name = scan.next();
		System.out.println("수정할 비밀번호 입력 : ");
		String pwd = scan.next();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		//DB
		userDAO.update2(map);
		System.out.println("DB의 내용을 수정하였습니다.");
				
		
	}

}
