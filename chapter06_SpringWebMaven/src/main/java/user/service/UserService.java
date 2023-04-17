package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;
import user.bean.UserImageDTO;

public interface UserService {

	void write(UserDTO userDTO);

	Map<Object, Object> getUserList(String pg);

	String isExistId(String id);

	UserDTO getUser(String id);

	void update(UserDTO userDTO);

	void delete(String id);

	void upload(UserImageDTO userImageDTO, List<String> fileNameList);

	List<UserImageDTO> getImageList();


}
