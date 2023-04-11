package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Transactional // 클래스 안에 있는 모든 메소드 Transactional
public class UserDAOMyBatis implements UserDAO {
	@Setter
	private SqlSession sqlSession;
	
	//@Transactional //자동으로 commit 과 close 를 진행 
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}
	
	//@Transactional
	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSql.getUserList");
	}


	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSql.getUser", id);
	}

	@Override
	public void update(Map<String, String> map) {
		sqlSession.update("userSql.update", map);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSql.delete", id);
	}

}
