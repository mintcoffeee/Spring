package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;


@Repository // DB와 연동하는 파일이기 때문에 Component 보다 @Repository 사용 
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	//<property name="dataSource" ref="dataSource" />
	//final은 override 가 안되기 때문에 메소드의 이름을 바꾸거나 생성자를 이용하여 dataSource값을잔달한다. 
	@Autowired
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource); // JdbcDaoSupport에 있는 setDataSource() 메소드를 호출 
	}

	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(:name,:id,:pwd)"; // ?,?,? 에 이름 부여 
		
		//named 의 파라미터를 받을 경우 전제조건으로 Map으로 받아야 한다.
		Map<String, String> map = new HashMap<>();
		map.put("name",userDTO.getName());
		map.put("id",userDTO.getId());
		map.put("pwd",userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map); //map이 같은 이름이랑 연결해서 값 도입   
	}
	
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
	
	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id=?";
		try {return getJdbcTemplate().queryForObject(  // 한사람 분량만 꺼내온다.
					sql,
					new BeanPropertyRowMapper<UserDTO>(),
					id);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}

	@Override
	public void update(UserDTO userDTO) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		
		//Map
		Map<String, String> map = new HashMap<>();
		map.put("name",userDTO.getName());
		map.put("id",userDTO.getId());
		map.put("pwd",userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public void update2(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
	}
	
	
	@Override
	public void delete(UserDTO userDTO) {
		String sql = "delete from usertable where id=:id";
		Map<String, String> map = new HashMap<>();
		map.put("id", userDTO.getId());
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	@Override
	public void delete2(String id) {
		String sql = "delete from usertable where id=:id";
		getJdbcTemplate().update(sql, id);
	}

	

	

		
}
