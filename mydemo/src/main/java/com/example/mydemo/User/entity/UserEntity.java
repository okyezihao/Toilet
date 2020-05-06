package com.example.mydemo.User.entity;

import org.springframework.stereotype.Component;

// 组件 <=> <bean id="userentity" class="com.example.User.entity.UserEntity"/>
@Component
public class UserEntity {   //实体类

    private Integer id;
    private String text;

    public UserEntity() {
    }

    public UserEntity(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

}
