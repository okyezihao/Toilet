package com.example.mydemo.User.dao;

import com.example.mydemo.User.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    // 无数据插入，有数据更新
    void addUpdate(UserEntity userEntity);

    // 增加User信息
    void addUser(UserEntity userEntity);

    // 删除User信息
    void delete(@Param("id") int id);

    // 更新User信息
    void update(UserEntity userEntity);

    // 计算数量
    int queryCount(@Param("id") int id);

    // 查询所有
    List<UserEntity> queryAll();

}
