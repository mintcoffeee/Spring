package user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import user.bean.UserDTO;

public interface UserDAO {
	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList();

	public void update(UserDTO userDTO);

	public void delete(UserDTO userDTO);
	
	public UserDTO getUser(String id);

	public void update2(Map<String, String> map);

	public void delete2(String id);

		
}
