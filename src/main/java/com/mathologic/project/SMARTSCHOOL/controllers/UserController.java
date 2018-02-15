package com.mathologic.project.SMARTSCHOOL.controllers;

import com.mathologic.project.SMARTSCHOOL.mongo.entity.User;
import com.mathologic.project.SMARTSCHOOL.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController implements Serializable {




    @Autowired
    UserService userService;

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public @ResponseBody
    String getTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String strDate= formatter.format(date);
        return strDate;
    }

    @RequestMapping(value = "/findByAllParams", method = RequestMethod.GET)
    public @ResponseBody
    Page<User> findByAllParams() {
        return this.userService.findByNameUserNameIsActive("santosh",true);
    }

}
