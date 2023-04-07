package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import lombok.Setter;
import user.bean.UserDTO;

/*
 * JdbcDaoSupport 상속안하고 직접 jdbcTemplate 만든 경우 
public class UserDAOImpl implements UserDAO {
	@Setter
	private JdbcTemplate jdbcTemplate = null; //null값 자동 초기화  

	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd()); //insert 없어서 update 사용, 입력과 수정을 다 한다.  
	}
	
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		//BeanPropertyRowMapper 행 안에 들어있는 한줄 한줄을 DTO에 매핑해주겠다. 
		//<UserDTO>, <> 공백 사용 가능 
	}
		

}
*/

/*
//JdbcDaoSupport를 상속 받음으로써 jdbcTemplate 자동 생성 
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());  
	}
	
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
		
}
*/

//NamedParameterJdbcDaoSupport 가장 최근에 나옴
//NamedParameter 파라미터에 이름 부여 가능 
//이전에 사용하던 메소드 다 호출 가능 
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

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
	public void delete(UserDTO userDTO) {
		String sql = "delete from usertable where id=:id";
		Map<String, String> map = new HashMap<>();
		map.put("id", userDTO.getId());
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

		
}
