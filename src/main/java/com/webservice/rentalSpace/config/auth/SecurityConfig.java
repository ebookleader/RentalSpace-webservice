package com.webservice.rentalSpace.config.auth;

import com.webservice.rentalSpace.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable() //h2-console 사용
                .and()
                    .authorizeRequests() //url별 권환 관리, antMatchers 옵션 사용
                    .antMatchers("/", "/css/**", "/img/**", "/js/**", "/h2-console/**", "/basicUser/**").permitAll()
                    .antMatchers("/api/v1/**", "/seller/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout().logoutSuccessUrl("/")
                .and()
                    .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService); //소셜 로그인 성공시 후속조치 진행


    }
}
