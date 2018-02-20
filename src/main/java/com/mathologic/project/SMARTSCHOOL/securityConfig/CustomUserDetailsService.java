package com.mathologic.project.SMARTSCHOOL.securityConfig;


import com.mathologic.project.SMARTSCHOOL.mongo.entity.User;
import com.mathologic.project.SMARTSCHOOL.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {




    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user = userService.findByNameUserNameIsActive(username,true);
       System.out.print(user);
//
//        if(user==null) {
//            throw new UsernameNotFoundException("No such user: " + username);
//        } else if (user.getRoles().isEmpty()) {
//            throw new UsernameNotFoundException("User " + username + " has no authorities");
//        }

        return null;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
