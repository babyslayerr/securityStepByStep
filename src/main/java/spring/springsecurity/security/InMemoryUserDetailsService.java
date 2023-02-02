package spring.springsecurity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/***
 * UserDetailsService의 구현체
 */
public class InMemoryUserDetailsService implements UserDetailsService {

    private List<UserDetails> users;

    public InMemoryUserDetailsService(List<UserDetails> users){
        this.users =  users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return users.stream().filter(u ->
                        u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found")
                );




    }
}
