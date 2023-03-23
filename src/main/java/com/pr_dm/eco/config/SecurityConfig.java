package com.pr_dm.eco.config;

///시큐리티 설정

import com.pr_dm.eco.config.oauth.OAuth2UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.DefaultSecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private final OAuth2UserInfoService oAuth2UserInfoService;


    @Bean
    protected DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
                .cors().and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/","/css/**","/js/**","h2-console/**","/profile").permitAll()
                        .antMatchers(
                                "/v2/api-docs",  "/configuration/ui",
                                "/swagger-resources", "/swagger-resources/**", "/configuration/security",
                                "/swagger-ui.html", "/webjars/**","/swagger/**",
                                /* swagger v3 */
                                "/v3/api-docs/**",
                                "/swagger-ui/**").permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/"))
                .oauth2Login(oauth2Login -> oauth2Login
                        .userInfoEndpoint()
                        .userService(oAuth2UserInfoService));
        return http.build();
    }
}
//h2 임시로 데이터 만들어두기 or db 연결