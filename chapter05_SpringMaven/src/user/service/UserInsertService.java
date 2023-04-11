package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserInsertService implements UserService {
	@Autowired
	private UserDTO userDTO=null;
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
