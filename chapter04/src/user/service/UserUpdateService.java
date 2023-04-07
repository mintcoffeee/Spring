package user.service;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserUpdateService implements UserService {
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.print("수정할 아이디 입력 : ");
		String id = scan.next();
		
		List<UserDTO> list = userDAO.getUserList();
		
		int sw=0;
		for(UserDTO userDTO : list) {
			if(userDTO.getId().equalsIgnoreCase(id)) {
				System.out.println("이름\t아이디\t비밀번호\t");
				System.out.println(userDTO.getName() +"\t"+
									userDTO.getId() +"\t"+
									userDTO.getPwd());
				System.out.println("수정할 이름 입력 : ");
				String name = scan.next();
				System.out.println("수정할 비밀번호 입력 : ");
				String pwd = scan.next();
				
				//DTO set
				userDTO.setName(name);
				userDTO.setPwd(pwd);
				
				//DB
				userDAO.update(userDTO);
				
				
				sw=1;
				break;
			};
		}//for
		
		if(sw==0) System.out.println("찾는 아이디가 없습니다.");
		
	}

}
