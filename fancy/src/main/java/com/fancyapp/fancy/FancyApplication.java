package com.fancyapp.fancy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

@SpringBootApplication
public class FancyApplication {

	private static final Logger log = LoggerFactory.getLogger(FancyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FancyApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(CarRepo carRepository){
		return(args) -> {
		    carRepository.deleteAll();
			carRepository.save(new Car("ESBC123", "Audi"));
			carRepository.save(new Car("SDE456", "Audi"));
			carRepository.save(new Car("WNFG789", "Porsche"));

		};

	}


	/*@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setViewClass(ThymeleafTilesView.class);
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setOrder(0);//HERE!!
		return viewResolver;
	}*/

	@Bean
	SpringResourceTemplateResolver htmlTemplateResolver(ApplicationContext applicationContext){
		SpringResourceTemplateResolver  templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false);

		return templateResolver;
	}

	@Bean
	SpringTemplateEngine templateEngine(ApplicationContext appContext){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.addTemplateResolver(htmlTemplateResolver(appContext));
		return templateEngine;
	}
}
