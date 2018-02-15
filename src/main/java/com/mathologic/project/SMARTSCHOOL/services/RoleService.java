package com.mathologic.project.SMARTSCHOOL.services;


import com.mathologic.project.SMARTSCHOOL.mongo.entity.Role;
import com.mathologic.project.SMARTSCHOOL.mongo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;


    @Transactional
    public Page<Role> getAllRoles() {
        return roleRepository.findAll((new PageRequest(0, 10)));
    }

    @Transactional
    public Role findById(String Id) {
        return roleRepository.findOne(Id);
    }

    @Transactional
    public Role getById(String Id) {
        return roleRepository.findOne(Id);
    }

    @Transactional
    public void deleteRole(String userId) {
        roleRepository.delete(userId);
    }

    @Transactional
    public boolean saveRole(Role role) {
        return roleRepository.save(role) != null;
    }

    @Transactional
    public boolean updateRole(Role role) {
        return roleRepository.save(role) != null;
    }
}
