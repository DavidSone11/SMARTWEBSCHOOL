package com.mathologic.project.SMARTSCHOOL.securityConfig;


import com.mathologic.project.SMARTSCHOOL.mongo.entity.User;
import com.mathologic.project.SMARTSCHOOL.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Page<User> user = userService.findByNameUserNameIsActive(username,true);

        return null;
    }
}
