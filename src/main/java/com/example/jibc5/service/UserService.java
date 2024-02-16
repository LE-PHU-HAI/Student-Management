package com.example.jibc5.service;

import com.example.jibc5.entity.User;
import com.example.jibc5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean checkPasswordUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user != null;
    }


    void save(User user) {
        // Các logic lưu user
    }

}
