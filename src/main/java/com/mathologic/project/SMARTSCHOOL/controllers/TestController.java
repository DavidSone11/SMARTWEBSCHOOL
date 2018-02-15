package com.mathologic.project.SMARTSCHOOL.controllers;




import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/v1/test")
public class TestController implements Serializable{



    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public @ResponseBody String getTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String strDate= formatter.format(date);
        return strDate;
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public @ResponseBody String getMessage() {
        return "HELLO WORLD";
    }



}
