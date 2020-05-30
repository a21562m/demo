package com.example.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.AppUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.Util;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public AppUser addUser(AppUser user)
    {
        return userRepository.save(user);
    }

    public List<AppUser> getUserList()
    {
        return userRepository.findAll();
    }

    public AppUser getUser(String id)
    {
        return userRepository.getOne(id);
    }

    public void deleteUser(String id)
    {
        userRepository.deleteById(id);
    }

    public AppUser update(String id, AppUser user)
    {
        AppUser currentInstance = userRepository.getOne(id);

        //support part update
        String[] nullPropertyNames = Util.getNullPropertyNames(user);
        BeanUtils.copyProperties(user, currentInstance, nullPropertyNames);

        return userRepository.save(currentInstance);
    }
}
