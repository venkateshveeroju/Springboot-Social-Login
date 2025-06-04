package dev.code.social_login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> {
                            auth.requestMatchers("/", "/error", "/webjars/**").permitAll();
                            auth.anyRequest().authenticated();
                        }
                ).logout(l -> l
                        .logoutSuccessUrl("/").permitAll()
                )
                .oauth2Login(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
