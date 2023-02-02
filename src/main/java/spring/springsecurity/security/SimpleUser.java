package spring.springsecurity.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
// UserDetails 를 구현한 SimpleUser 만들기
public class SimpleUser implements UserDetails {

    private String username;

    private String password;

    private String authority;

    public SimpleUser(String username, String password,String authority){
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()->authority);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    // security.core.userDetails 의 user클래스를 이용하면 구현할 필요없이 빌더클래스를 이용해서 인스턴스를 얻을수 있따
    // UserDetails u = User.withUsername("username").password("1234").authorities("read","write").disabled(true).build
}
