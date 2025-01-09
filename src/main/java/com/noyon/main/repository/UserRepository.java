package com.noyon.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noyon.main.entities.User;
@Repository

public interface UserRepository extends JpaRepository<User, Long> {

}
