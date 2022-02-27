package me.g1tommy.etfportfolioanalyzer;

import me.g1tommy.etfportfolioanalyzer.entity.etf;
import me.g1tommy.etfportfolioanalyzer.entity.isustock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class EtfPortfolioAnalyzerApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(EtfPortfolioAnalyzerApplication.class, args);
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
		CorsRegistry cors) {
		config.exposeIdsFor(etf.class);
		config.exposeIdsFor(isustock.class);

		cors.addMapping("/*")
			.allowedOrigins("*")
			.allowedMethods("GET")
			.allowCredentials(false)
			.maxAge(3600);
	}
}
