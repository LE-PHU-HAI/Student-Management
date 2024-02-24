package com.example.jibc5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.jibc5.entity.User;
import com.example.jibc5.repository.UserRepository;
import com.example.jibc5.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Page<User> getAllUsersPaginated(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo - 1, 5);
        return userRepository.findAll(pageRequest);
    }

    @Override

    public boolean checkPasswordUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user != null;
    }
}