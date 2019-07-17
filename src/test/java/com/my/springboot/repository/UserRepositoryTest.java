package com.my.springboot.repository;

import com.my.springboot.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll(){
        List<User> userList = userRepository.findAll();
        Assert.assertNotEquals(null, userList.size());
        if(userList.size()>0){
            System.out.println(userList.get(0).toString());
        }
    }

    @Transactional
    @Test
    public void findUserById(){
        User user = userRepository.getOne(1L);
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void save(){
        User user = new User();
        user.setId(2L);
        user.setUserName("李白");
        user.setPassword("123");
        user = userRepository.save(user);
        Assert.assertNotNull(user);
    }

    @Transactional
    @Rollback(false) //设置事务不回滚
    @Test
    public void update(){
        User user = new User();
        user.setId(2L);
        user.setPassword("456");
        Integer a = userRepository.updatePasswordById(user.getId(), user.getPassword());
        Assert.assertEquals(Integer.valueOf(1), a);
    }

    @Transactional
    @Rollback(false) //设置事务不回滚
    @Test
    public void delete(){
        userRepository.deleteById(2L);
    }
}