package spring.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import spring.springsecurity.security.CustomAuthenticationProvider;

@Configuration
public class DevSecurityConfig {

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    // 제대로 적용이 안되는 것 같은데...
    // 웹 브라우저에서는 되고 포스트맨에서는 인증을 받네 tool이라서 ip도 같은건데 뭐가 차이가 있나?
    // 후에 알게 되겠지
    // permitall일때 postman에서 바디로 응답 해주는것으로 보아 뭔가 설정이 있는듯
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // WebSecurityConfigurerAdapter 을 더이상 상속을 하여 재정의 하지않고
        // 그냥 filterChain 이름의 bean을 등록 함

        // httpBasic 권한 흐름 사용 header에 Authentication : Basic <user>:<password> 사용(user,password는 encoding되어야함)
        http.httpBasic();

        // 모든 요청에 대해 인증설정
        http.authorizeHttpRequests().anyRequest().authenticated();

        return http.build();
    }

    // authenticationProvider을 authenticationManger에 다시 세팅
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
        return authenticationManagerBuilder.build();
    }
}
