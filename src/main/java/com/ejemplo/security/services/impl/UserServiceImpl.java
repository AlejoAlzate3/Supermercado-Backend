package com.ejemplo.security.services.impl;

import com.ejemplo.security.repository.UserRepository;
import com.ejemplo.security.services.UserService;
import com.ejemplo.security.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
