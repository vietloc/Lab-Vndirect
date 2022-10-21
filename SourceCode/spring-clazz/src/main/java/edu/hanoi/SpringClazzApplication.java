package edu.hanoi;

import edu.java.web.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = "edu.*")
//@ImportResource("classpath:config.xml")
public class SpringClazzApplication {

	public static void main(String[] args) {
		//SpringApplication.run() tra ve 1 Obj
		SpringApplication.run(SpringClazzApplication.class, args);
	}
//	@Bean
//	public InternalResourceViewResolver viewResolver(){
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/jsp/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
//	@Bean
//	public TilesConfigurer tilesConfigurer(){
//		TilesConfigurer configurer = new TilesConfigurer();
//		configurer.setDefinitions("/tiles/definitions.xml");
//		return configurer;
//	}
}
