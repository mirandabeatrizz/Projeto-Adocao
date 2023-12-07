package com.example.registrationlogindemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

 
@Configuration //classe de configuraçaõ
@EnableWebSecurity //classe de segurança
public class SpringSecurity {

    @Autowired // qm é autorizado
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean // executado assim q o codigo é executado
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //filtros
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/css/**","/img/**", "/js/**", "C:/**").permitAll() 
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/todosAnimais/**").permitAll()
                                .requestMatchers("/infoAnimal/**").permitAll()
                                .requestMatchers("/formInteresse/**").permitAll()
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/animais/**").permitAll()

                                .requestMatchers("/users").hasRole("ADMIN")
                                .requestMatchers("/interesse/**").hasRole("ADMIN")
                                .requestMatchers("/cadastroAnimais").hasRole("ADMIN")
                                .requestMatchers("/listaInteressados").hasRole("ADMIN")
                                .requestMatchers("/register").hasRole("ADMIN")
                                .requestMatchers("/register/save").hasRole("ADMIN")
                                 .requestMatchers("/upload").hasRole("ADMIN")
                ).formLogin(
                form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/users")
                        .permitAll()
        ).logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
        );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
