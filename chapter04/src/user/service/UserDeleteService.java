package user.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserDeleteService implements UserService {
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.print("삭제할 아이디 입력 : ");
		String id = scan.next();
		
		List<UserDTO> list = userDAO.getUserList();
		Iterator<UserDTO> it = list.iterator();
		int sw=0;
		while(it.hasNext()) {
			UserDTO userDTO = it.next();
			if(userDTO.getId().equalsIgnoreCase(id)) {
				sw=1;
				userDAO.delete(userDTO);
				System.out.println(id+"님의 데이터를 삭제하였습니다");
			}//if
			
		}//while
		if(sw==0) System.out.println("찾는 아이디가 없습니다.");
		
	}

}
