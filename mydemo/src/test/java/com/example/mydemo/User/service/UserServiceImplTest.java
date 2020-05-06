package com.example.mydemo.User.service;

import com.example.mydemo.User.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    @Transactional
    public void addUpdate() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(5);
        userEntity.setText("f*ck_u");
        try {
            userService.addUpdate(userEntity);
            System.out.println("插入成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    public void delete() {
        int id = 5;
        try {
            userService.delete(id);
            System.out.println("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Transactional
    public void queryAll() {

        try {
            List<UserEntity> allUser = userService.queryAll();
            for (UserEntity userEntity : allUser) {
                System.out.println(userEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
