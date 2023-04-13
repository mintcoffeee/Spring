package user.service;

import java.util.Map;

import user.bean.UserDTO;

public interface UserService {

	void write(UserDTO userDTO);

	Map<Object, Object> getUserList(String pg);

	String isExistId(String id);

	UserDTO getUser(String id);

	void update(UserDTO userDTO);

	void delete(String id);


}
