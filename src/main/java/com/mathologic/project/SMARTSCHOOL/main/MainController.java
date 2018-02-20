package com.mathologic.project.SMARTSCHOOL.main;


import com.mathologic.project.SMARTSCHOOL.mongo.entity.Role;
import com.mathologic.project.SMARTSCHOOL.mongo.entity.Station;
import com.mathologic.project.SMARTSCHOOL.mongo.entity.User;
import com.mathologic.project.SMARTSCHOOL.mongo.repositories.RoleRepository;
import com.mathologic.project.SMARTSCHOOL.mongo.repositories.StationRepository;
import com.mathologic.project.SMARTSCHOOL.mongo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

@ComponentScan(basePackages = { "com.mathologic.project.SMARTSCHOOL.main",
                                "com.mathologic.project.SMARTSCHOOL.controllers",
                                "com.mathologic.project.SMARTSCHOOL.securityConfig",
                                "com.mathologic.project.SMARTSCHOOL.mongo.entity",
                                "com.mathologic.project.SMARTSCHOOL.services"
                            })

//@EnableJpaRepositories(basePackages = { "com.mathologic.projects.SMARTSCHOOL.repositories"})

@Configuration
@EnableAutoConfiguration
//@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableMongoRepositories(value= {"com.mathologic.project.SMARTSCHOOL.mongo.repositories"})
@SpringBootApplication

public class MainController extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public StationRepository getStationRepository() {
        return stationRepository;
    }

    public void setStationRepository(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Autowired
    StationRepository stationRepository;

     public static void main(String []args){
         SpringApplication.run(MainController.class, args);
     }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainController.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Logger logger = LoggerFactory.getLogger(MainController.class);
        logger.trace("Hello World");
        logger.debug("Hello World");
        logger.info("Hello World");
        logger.warn("Hello World");
        logger.error("Hello World");
        //createRole();
       // createUser();
        //createStation();
    }

    public void createStation(){

        Station stn  = new Station();
        stn.setCode("HSB");
        stn.setName("HSBC");
//        stn.setNumberOfBeds(1);
//        stn.setHeadStationSignOffDuration(30L);
//        stn.setHeadStationSignOnDuration(30L);
//        stn.setOutStationSignOffDuration(30L);
//        stn.setOutStationSignOnDuration(30L);
        stn.setMarkDelete(true);


        stationRepository.save(stn);
    }

    public void createRole(){
        roleRepository.save(new Role("super"));
        roleRepository.save(new Role("admin"));
        roleRepository.save(new Role("guest"));


    }
    public void createUser(){

         User user = null;
        Role roleRefOBJ= roleRepository.findByRoleName("admin");

         if(user ==null){
             user = new User("santosh123","admin","santosh@gmail.com","7406465159","123456","santosh","sahu",true,new Date(),"super");
             user.setRoleRef(roleRefOBJ);
             userRepository.save(user);

         }

    }



}