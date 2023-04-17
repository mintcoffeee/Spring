package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;
import user.bean.UserImageDTO;

public interface UserDAO {

	void write(UserDTO userDTO);

	List<UserDTO> getUserList(Map<String, Integer> map);

	UserDTO getUser(String id);

	void update(UserDTO userDTO);

	void delete(String id);

	int getTotalA();

	void upload(UserImageDTO userImageDTO, List<String> fileNameList);

	List<UserImageDTO> getImageList();

}
