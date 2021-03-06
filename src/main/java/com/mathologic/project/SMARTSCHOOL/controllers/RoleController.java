package com.mathologic.project.SMARTSCHOOL.controllers;

import com.mathologic.project.SMARTSCHOOL.mongo.entity.Role;
import com.mathologic.project.SMARTSCHOOL.services.RoleService;
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
 * RoleController
 * RoleService
 */
@RestController
@RequestMapping("api/v1/role")
public class RoleController implements Serializable {




    @Autowired
    RoleService roleService;

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
    Page<Role> findByAllParams() {
        return this.roleService.getAllRoles();

    }

}
