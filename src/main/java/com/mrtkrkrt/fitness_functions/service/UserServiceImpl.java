package com.mrtkrkrt.fitness_functions.service;

import com.mrtkrkrt.fitness_functions.model.User;
import com.mrtkrkrt.fitness_functions.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User register(User user) {
        return user;
    }
}
