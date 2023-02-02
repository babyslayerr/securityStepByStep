package spring.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import spring.springsecurity.security.InMemoryUserDetailsService;
import spring.springsecurity.security.SimpleUser;

import java.util.List;

// 이것만 사용하면 userDetailService와 passwordEncoder만 재정의하고
// authentication provider을 재정의 하면 윗 단계 까지 재정의 한거임
@Configuration
public class UserManagementConfig {

//    @Bean
//    public UserDetailsService userDetailsService(){
//        // 메모리 영역에 자격증명을 저장하는 사용자 세부 정보 서비스를 생성한다.(인증 공급자가 참조하는)
//        var userDetailService =
//                new InMemoryUserDetailsManager();
//        // 자격증명이 있는 사용자를 만든다( 사용자 이름,비밀번호,권한을 생성한다.)
//        var user = User.withUsername("user")
//                .password("12345678")
//                .authorities("read")
//                .build();
//        // 사용자를 userDetailService가 관리하도록 추가한다.
//        userDetailService.createUser(user);
//        return userDetailService;
//    }
    @Bean
    public UserDetailsService userDetailsService(){

        SimpleUser user = new SimpleUser("bill","123456789","READ");
        List<UserDetails> users = List.of(user);
        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 일반 텍스트 처럼 관리(간단한 문자열만 비교하는 passEncoder)
        // deprecated됨
        return NoOpPasswordEncoder.getInstance();
    }
}
