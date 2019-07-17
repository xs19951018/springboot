package com.my.springboot.repository;

import com.my.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User,JPA
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /*User findByUserName(String userName);
    User findByUserNameandAndEmail(String userName, String email);*/

    @Query("update User u set u.password = :password where u.id = :id")
    @Modifying
    Integer updatePasswordById(@Param("id") Long id, @Param("password") String password);
}
