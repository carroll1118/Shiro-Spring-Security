package com.example.springbootshiroproject.mapper;

import com.example.springbootshiroproject.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther Carroll
 * @Date 2020/5/25
 * @e-mail ggq_carroll@163.com
 */
@Repository
@Mapper
public interface UserMapper {
    public User queryUserByName(String name);
}
