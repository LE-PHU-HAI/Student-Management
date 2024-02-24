package com.example.jibc5.service;

import com.example.jibc5.entity.Student;
import com.example.jibc5.entity.User;
import com.example.jibc5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface UserService {

    boolean checkPasswordUser(String email, String password);

    Page<User> getAllUsersPaginated(int pageNo, int pageSize);
}