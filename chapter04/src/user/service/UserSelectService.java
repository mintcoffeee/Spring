package user.service;

import java.util.List;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserSelectService implements UserService {
	private UserDAO userDAO=null;

	@Override
	public void execute() {
		System.out.println();
		
		List<UserDTO> list = userDAO.getUserList();
		System.out.println("이름\t아이디\t비밀번호\t");
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" +
								userDTO.getId() + "\t" +
								userDTO.getPwd());
		}
		
	}

}
