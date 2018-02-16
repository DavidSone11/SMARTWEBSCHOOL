package com.mathologic.project.SMARTSCHOOL.controllers;

import com.mathologic.project.SMARTSCHOOL.mongo.entity.Role;
import com.mathologic.project.SMARTSCHOOL.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * RoleController
 * RoleService
 */
@RestController
@RequestMapping("api/v1/upload")
public class UploadController implements Serializable {






    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public @ResponseBody String getTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String strDate= formatter.format(date);
        return strDate;
    }

    @RequestMapping(value = "/stationUpload", method = RequestMethod.POST)
    public @ResponseBody void stationUpload(@RequestParam("file") MultipartFile stationDetails) {

            System.out.print(""+stationDetails);

    }

}
