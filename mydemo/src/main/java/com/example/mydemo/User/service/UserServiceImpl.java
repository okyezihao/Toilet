package com.example.mydemo.User.service;

import com.example.mydemo.User.dao.UserDao;
import com.example.mydemo.User.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // service层 调用 dao层
    // 自动注入
    @Autowired
    UserDao userDao;

    // 创建 Log 对象打印日志
    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public void addUpdate(UserEntity userEntity) {

        // 若id非空则 , 执行更新操作
        if (userDao.queryCount(userEntity.getId()) == 1) {
            userDao.update(userEntity);
        } else {
            userDao.addUser(userEntity);
        }

        log.info("====================测试插入更新====================");

    }


    public void delete(int id) {
        userDao.delete(id);
    }

    public List<UserEntity> queryAll() {
        return userDao.queryAll();
    }

}