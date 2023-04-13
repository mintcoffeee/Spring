package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:spring/db.properties") //db.properties
@EnableTransactionManagement //트랜잭션을 사용하겠습니다. 하는 어노테이션 
public class SpringConfiguration {
	
	private @Value("${jdbc.driver}") String driver;
	private @Value("${jdbc.url}") String url;
	private @Value("${jdbc.username}") String username;
	private @Value("${jdbc.password}") String password;
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		return basicDataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		// ClassPathResource: Resource 를 제공한다. setConfigLocation 단수, 여러개 안된다. 
		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper.xml"));
		
		return sqlSessionFactoryBean.getObject(); //sqlSessionFactory 리턴해주는 메소드 
	}
	
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception{
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sqlSessionTemplate; 
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
}

/*
만약에 mapper.xml이 여러개일 경우 
1.
sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper.xml"),
										 new ClassPathResource("board/dao/boardMapper.xml"),
										 new ClassPathResource("brand/dao/brandMapper.xml"),
										 new ClassPathResource("product/dao/productMapper.xml"),
										 ...);

2.
필드
@Autowired
private ApplicaitonContext context; 
*/
//와일드 카드(*) 사용 
//sqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:*/dao/*Mapper.xml"));

 




