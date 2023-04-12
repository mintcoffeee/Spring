package user.service;

import java.util.List;

import user.bean.UserDTO;

public interface UserService {

	void write(UserDTO userDTO);

	List<UserDTO> getUserList();

	String isExistId(String id);

	UserDTO getUser(String id);

	void update(UserDTO userDTO);


}
