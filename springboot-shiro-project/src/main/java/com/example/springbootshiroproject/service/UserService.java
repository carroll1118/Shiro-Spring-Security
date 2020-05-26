package com.example.springbootshiroproject.service;


import com.example.springbootshiroproject.pojo.User;

public interface UserService {

    public User queryUserByName(String name);
}
