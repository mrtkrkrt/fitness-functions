package com.mrtkrkrt.fitness_functions.repository;

import com.mrtkrkrt.fitness_functions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
