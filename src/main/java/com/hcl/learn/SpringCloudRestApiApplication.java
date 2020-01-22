package com.hcl.learn;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class SpringCloudRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRestApiApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localResolver = new AcceptHeaderLocaleResolver();
		localResolver.setDefaultLocale(Locale.US);
		return localResolver;
	}

	/*
	 * @Bean public ResourceBundleMessageSource bundleMessageSource() {
	 * ResourceBundleMessageSource messageSource = new
	 * ResourceBundleMessageSource(); messageSource.setBasename("messages"); return
	 * messageSource; }
	 */
}
