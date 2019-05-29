package security.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import security.service.mapper.UserDaoMapper;

@Configuration
@EnableTransactionManagement
//Mapperを自動検出
@MapperScan("security.service.mapper")
public class MyBatisConfig {
	@Autowired
	private DataSource dataSource;

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory()
			throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		//application.propertiesで設定可能になったため、そちらに記載
		//factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		//アノテーションでSQL文を記述
		/*factoryBean.setMapperLocations(
			new Resource[] {new ClassPathResource("security/dao/user.xml"))}
		);*/
		//DataSourceに対してSQLスクリプトを実行
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.addScripts(
			new ClassPathResource("script/schema.sql"),
			new ClassPathResource("script/data.sql")
		);
		resourceDatabasePopulator.execute(dataSource);

		return sqlSessionFactoryBean;
	}

	@Bean
	public UserDaoMapper userDaoMapper(SqlSessionFactory sqlSessionFactoryBean) {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryBean);
		return sqlSessionTemplate.getMapper(UserDaoMapper.class);
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
}
