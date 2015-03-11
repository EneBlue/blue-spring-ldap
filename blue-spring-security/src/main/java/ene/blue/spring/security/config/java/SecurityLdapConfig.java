package ene.blue.spring.security.config.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * LDAP������Ŀ¼����Э�飬Lightweight Directory Access Protocol
 * ���ǻ���X.500��׼
 * @author zhangrui
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityLdapConfig extends HttpWebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.ldapAuthentication()
			.userDnPatterns("uid={0},ou=people")
			.groupSearchBase("ou=groups");
	}
}
