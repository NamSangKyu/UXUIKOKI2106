package org.korea;

import org.korea.dao.MemberDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import config.DBManager;

@Configuration
public class DIContainer {
	@Bean
	public DBManager manager() {
		return new DBManager();
	}
	@Bean
	public MemberDAO member() {
		return new MemberDAO(manager());
	}
	
}





