package kr.or.hoseo.springproject.chapter6.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;
	
	private final String USER_QUERY = 
			"SELECT id, pwd, true from users where id = ?";
	private final String ROLES_QUERY = 
			"SELECT user_id, role_name from role_user_mapping where user_id = ? ";
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(ds)
			.usersByUsernameQuery(USER_QUERY)
			.authoritiesByUsernameQuery(ROLES_QUERY);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/add").hasAuthority("ROLE_ADMIN")
				.and()
			.formLogin()
				.defaultSuccessUrl("/")
				.loginPage("/login")
				.loginProcessingUrl("/loginProcess")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.and()
			.csrf()
				.disable();
	}
}
