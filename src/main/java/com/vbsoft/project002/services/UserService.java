package com.vbsoft.project002.services;

import com.vbsoft.project002.domain.User;
import com.vbsoft.project002.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
    return repo.findAll();
    }
}
