package com.marcin.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //  @Autowired
    // private DataSource dataSource;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication().withUser("marcin").password(passwordEncoder().encode("pass")).roles("USER")
                .and().withUser("admin").password(passwordEncoder().encode("pass")).roles("ADMIN");
/*
                .userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .authenticationProvider(authenticationProvider());

 */
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/list").authenticated()
                .antMatchers("/").permitAll()
                .antMatchers("/showFormForAdd").authenticated()
                .antMatchers("/h2-console").permitAll()
                .and()
                .formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .defaultSuccessUrl("/myPage")
                .and()
                .logout()
                .logoutSuccessUrl("/");




        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    /*
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

     */

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
