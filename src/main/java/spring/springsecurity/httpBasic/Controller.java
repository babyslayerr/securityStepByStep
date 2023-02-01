package spring.springsecurity.httpBasic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    // Http Basic 인증 흐름
    // header에 key : autentication value : Basic + <user>:<password>를 encoding 한 값으로 같이 던져줌
    // spring security 기본 설정에서 userDetailService에 자격증명이 등록(메모리)되며
    // passEncoder 아직 구현 안되어있음

}
