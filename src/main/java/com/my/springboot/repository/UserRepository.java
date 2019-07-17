package com.my.springboot.repository;

import com.my.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User,JPA
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /*User findByUserName(String userName);
    User findByUserNameandAndEmail(String userName, String email);*/

}
