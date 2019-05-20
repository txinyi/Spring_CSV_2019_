package csv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder; 
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; 

@SpringBootApplication(scanBasePackages = {"csv"}) 
@ComponentScan({"csv", "csv.controller", "csv.domain", "csv.processor", "csv.repository"})
@EntityScan("csv")
@EnableJpaRepositories("csv")
public class Application extends SpringBootServletInitializer { 
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
