package pl.edu.wszib.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import pl.edu.wszib.authentication.wrapper.CustomUserDetails;
import pl.edu.wszib.domain.repository.CustomerRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"pl.edu.wszib"})
@EnableScheduling
public class AppConfig extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppInitializer.class);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, CustomerRepository repo) throws Exception {
        builder.userDetailsService(s -> new CustomUserDetails(repo.findByEmail(s)));
    }
}