package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {

	void write(UserDTO userDTO);

	List<UserDTO> getUserList(Map<String, Integer> map);

	UserDTO getUser(String id);

	void update(UserDTO userDTO);

	void delete(String id);

	int getTotalA();

}
