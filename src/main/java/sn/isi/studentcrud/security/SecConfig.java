package sn.isi.studentcrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecConfig extends  WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder passwordEncoder = passwordEncoder();
        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("passer")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("passer")).roles("ADMIN","USER");
    }

    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin();
        http.authorizeRequests().antMatchers("/formStudent**/**").hasRole("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
