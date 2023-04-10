package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@Configuration :	SpringConfiguration 은 일반 자바 파일이 아니다.
// 					applicationContext.xml 과 같은 환경설정 파일이다. 

@PropertySource("classpath:spring/db.properties") //db.properties
public class SpringConfiguration {
	//lombok 아님 주의!
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
//	BasicDataSource: ConnectionPool 을 만들어 주는 class 
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		
//		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		basicDataSource.setUsername("c##java");
//		basicDataSource.setPassword("1234");
		
		
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		return basicDataSource;
	}
}

