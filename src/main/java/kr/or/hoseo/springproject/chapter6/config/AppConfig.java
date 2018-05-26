package kr.or.hoseo.springproject.chapter6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("kr.or.hoseo.springproject.chapter6")
public class AppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Configuration
	@PropertySource(value = { "classpath:properties/defaults.properties" })
	static class Defaults {
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertyConfigInProduction() {
			return new PropertySourcesPlaceholderConfigurer();
		}
	}

	@Configuration
	@Profile("test")
	@PropertySource(value = { "classpath:properties/test.properties" })
	static class Test {

		@Configuration
		@Import(Defaults.class)
		static class innerConfig {
		};

		@Bean
		public static PropertySourcesPlaceholderConfigurer propertyConfigInProduction() {
			return new PropertySourcesPlaceholderConfigurer();
		}
	}

	@Configuration
	@Profile("production")
	@PropertySource(value = { "classpath:properties/production.properties" })
	static class Production {

		@Configuration
		@Import(Defaults.class)
		static class innerConfig {
		};

		@Bean
		public static PropertySourcesPlaceholderConfigurer propertyConfigInProduction() {
			return new PropertySourcesPlaceholderConfigurer();
		}
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
}
