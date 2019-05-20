package csv;
  
import org.springframework.batch.core.launch.JobLauncher; 
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean; 
import org.springframework.batch.support.transaction.ResourcelessTransactionManager; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;  

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;  

import org.springframework.web.servlet.ViewResolver; 
import org.springframework.web.servlet.config.annotation.EnableWebMvc; 
import org.springframework.web.servlet.view.InternalResourceViewResolver; 


@EnableWebMvc
@Configuration
public class ApplicationConfiguration { // extends WebMvcConfigurerAdapter

    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/pages/"); 	///WEB-INF/classes/templates/
        bean.setSuffix(".jsp");
        return bean;
    } 
}