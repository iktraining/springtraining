package security.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("db.properties") //profile読み込み
public class DataSourceConfig {

	//サードパーティDataSource向け
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	//${}の書式を解析するための定義。<context:property-placeholder>タグに該当する。
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfih() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	//DataSourceのBean定義
	//DataSourceの実装オブジェクトを生成して、プロパティ設定している
	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driverClassName);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		return basicDataSource;
	}

	//組み込みDataSource向け
	/*
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("script/table.sql")
				.addScript("script/data.sql")
				.build();
	}
	*/

}
