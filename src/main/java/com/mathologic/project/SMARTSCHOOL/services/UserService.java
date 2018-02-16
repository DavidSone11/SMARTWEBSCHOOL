package com.mathologic.project.SMARTSCHOOL.services;


import com.mathologic.project.SMARTSCHOOL.mongo.entity.User;
import com.mathologic.project.SMARTSCHOOL.mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {



    @Autowired
    UserRepository userRepository;

    @Transactional
    public Page<User> getAllUsers() {
        return userRepository.findAll((new PageRequest(0, 10)));
    }

    @Transactional
    public User findById(String Id) {
        return userRepository.findOne(Id);
    }

    @Transactional
    public User getById(String Id) {
        return userRepository.findOne(Id);
    }

    @Transactional
    public void deleteUser(String userId) {
         userRepository.delete(userId);
    }

    @Transactional
    public boolean saveUser(User user) {
        return userRepository.save(user) != null;
    }

    @Transactional
    public boolean updateUser(User user) {
        return userRepository.save(user) != null;
    }

    @Transactional
    public User findByNameUserNameIsActive(String username, boolean isTrue){
        return  userRepository.findByNameUserNameIsActive(username,isTrue);
    }

    @Transactional
    public User findByFirstNameAndLastName(String firstnama, String  lastname){
        return  userRepository.findByNameFirstNameAndLastName(firstnama,lastname);
    }
}
