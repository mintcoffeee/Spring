package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService {
	private UserDTO userDTO=null;
	private UserDAO userDAO=null;

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

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
