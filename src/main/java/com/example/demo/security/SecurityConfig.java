package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from user where username=?")
                .authoritiesByUsernameQuery(
                        "select username, authority" + " from authority where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login**", "/logout**", "/css/**", "/image/**").permitAll()
                .antMatchers("/h2-console/**").hasAuthority("SECRETARIAT")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login") // Identification via ma page de login (/login)
                .and()
                .exceptionHandling().accessDeniedPage("/") // Si pas les droit, retourn sur la page d'acceuil (/)
                .and()
                .logout().logoutSuccessUrl("/") // Indiquue que le logout est permis et renvoie vers
                                                // l'acceuil (/)
        ;

        // this will ignore only h2-console csrf, spring security 4+
        http.csrf().ignoringAntMatchers("/h2-console/**");
        // this will allow frames with same origin which is much more safe
        http.headers().frameOptions().sameOrigin();
    }

}