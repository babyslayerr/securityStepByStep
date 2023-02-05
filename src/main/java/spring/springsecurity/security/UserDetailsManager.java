package spring.springsecurity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/***
 * UserDetailsService를 상속한 interface며 다양한 기능들(ex 사용자 추가, 삭제)들을 정의 할 수 있다.
 * 이 인터페이스를 사용해서 나만의 Custom한 manager를 만들 수 있다.
  */

public interface UserDetailsManager extends UserDetailsService {

    void createUser(UserDetails userDetails);

    void updateUser(UserDetails userDetails);

    void deleteUser(String username);

    void changePassword(String oldPassword, String newPassword);

    boolean userExists(String username);

}
