package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

//@Component 포괄적인 의미의 bean
//@Repository 

@Service
public class UserInsertService implements UserService {
	@Autowired
	private UserDTO userDTO=null;
	//@Autowired: 생성된 빈들중에서 UserDTO 타입을 찾아서 자동으로 mapping 해라  
	
	@Autowired
	private UserDAO userDAO=null;

	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		//DATA
		System.out.print("이   름 입력 : ");
		String name =scan.next();
		System.out.print("ID 입력 : ");
		String id = scan.next();
		System.out.print("PASSWORD 입력 : ");
		String pwd = scan.next();
		System.out.println();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);

		//DB
		userDAO.write(userDTO);
	
	}

}
