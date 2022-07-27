package com.monster.comu.config;

import com.monster.comu.config.auth.CustomOAuth2UserService;
import com.monster.comu.config.auth.PrincipalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalDetailService principalDetailService;
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/images/**", "/login/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/user/login")
                .loginProcessingUrl("/auth/user/login")
                .defaultSuccessUrl("/")
                .and()
                .oauth2Login()
                .loginPage("/auth/user/login")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
        http
                .rememberMe().tokenValiditySeconds(60 * 60 * 7)
                .userDetailsService(principalDetailService);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
