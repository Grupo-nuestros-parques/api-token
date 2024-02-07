package com.nuestrosparques.token.app.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private static String TOKEN_USERNAME = "ares_prd";
    private static String TOKEN_PASSWORD = "nb2qEET72NTRpq7W7Z3267128";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        if(username.equalsIgnoreCase(TOKEN_USERNAME)){
            authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
            return new User("ares_prd", "nb2qEET72NTRpq7W7Z3267128", authorityList);
        }else {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }
}