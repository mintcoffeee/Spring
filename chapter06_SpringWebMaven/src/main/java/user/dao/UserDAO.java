package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {

	void write(UserDTO userDTO);

	List<UserDTO> getUserList();

	UserDTO getUser(String id);

	void update(UserDTO userDTO);

}
