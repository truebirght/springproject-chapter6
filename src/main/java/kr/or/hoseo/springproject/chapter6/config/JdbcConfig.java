package kr.or.hoseo.springproject.chapter6.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.util.StringUtils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class JdbcConfig {
	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.testQuery}")
	private String testQuery;

	//@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		config.setDriverClassName(driverClassName);
		if (StringUtils.isEmpty(testQuery) == false) {
			config.setConnectionTestQuery(testQuery);
		}
		return new HikariDataSource(config);
	}

	@Bean
	//@Profile("test")
	@Primary
	public DataSource h2DataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.HSQL) // .H2 or .DERBY
				.addScript("sql/create-table.sql")
				//.addScript("insert-samples.sql")
				.build();
	}

	@Bean
	JdbcTemplate jdbcTemplate(@Autowired DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
