package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
import user.bean.UserImageDTO;

@Repository
@Transactional
public class UserDAOMyBatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);		
	}

	@Override
	public List<UserDTO> getUserList(Map<String, Integer> map) {
		return sqlSession.selectList("userSQL.getUserList", map);
		//selectList는 List 형태로 mapper파일로 들어간다. 
		//resultType="user" 는 select * from 에서 선택된 행 들을 dto 에 담는다.
		//이 dto를 사전에 형성된 List 형태에 담아서 받아온다. 
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser",id);
	}

	@Override
	public void update(UserDTO userDTO) {
		Map<String,String> map = new HashMap<>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		sqlSession.update("userSQL.update", userDTO);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete",id);
	}

	@Override
	public int getTotalA() {
		return sqlSession.selectOne("userSQL.getTotalA");
	}

	@Override
	public void upload(UserImageDTO userImageDTO, List<String> fileNameList) {
		for(String fileName : fileNameList) {
			userImageDTO.setImage1(fileName);
			sqlSession.insert("userSQL.upload", userImageDTO);
		}
	}

	@Override
	public List<UserImageDTO> getImageList() {
		return sqlSession.selectList("userSQL.getImageList");
	}

}






