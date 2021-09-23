package org.korea;

import org.korea.tanslate.TranslateModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIContainer {
	@Bean
	public TranslateModule translateModule() {
		return new TranslateModule();
	}
}
