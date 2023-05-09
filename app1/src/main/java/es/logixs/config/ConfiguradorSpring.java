package es.logixs.config;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("es.logixs")
@PropertySource("classpath:database.properties")
@EnableWebMvc
public class ConfiguradorSpring  {

	private ApplicationContext contexto;
	@Value("${url}")
	String url;
	@Value("${user}")
	String user;
	@Value("${password}")
	String password;

    @Bean
    public DataSource dataSourceMySQL()
    {
		System.out.println(url);
		System.out.println(password);
		System.out.println(user);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
        return dataSource;
    }
	@Bean
	public JdbcTemplate template() {
		
		return new JdbcTemplate(dataSourceMySQL());
	}
	

}
