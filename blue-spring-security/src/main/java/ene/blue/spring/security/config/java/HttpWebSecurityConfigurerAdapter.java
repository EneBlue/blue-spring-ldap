package ene.blue.spring.security.config.java;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class HttpWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			/* ���е��û������Խ�����/resources/��ͷ��URl��ͬʱ���Խ���/singup�� /about��URL */
			.antMatchers("/resources/**", "/singup", "/about").permitAll()
			/* �û�ROLE_ADMINȨ�޵��û�����ʹ��/admin/**��URL */
			.antMatchers("/admin/**").hasRole("ADMIN")
			/* ʹ��/db/**���û�������ROLE_ADMIN��ROLE_DBAȨ�� */
			.antMatchers("/db/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_DBA')")
			.anyRequest().authenticated()
			.and()
			/* �������û���/login�����֤ */
			.formLogin().loginPage("/login").permitAll()
			.and().httpBasic();
	}
	
}
