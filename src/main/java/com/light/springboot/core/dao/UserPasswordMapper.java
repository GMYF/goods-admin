package com.light.springboot.core.dao;

import com.light.springboot.core.domain.user.UserPassword;

import java.util.List;

public interface UserPasswordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPassword record);

    UserPassword selectByPrimaryKey(Integer id);

    List<UserPassword> selectAll();

    int updateByPrimaryKey(UserPassword record);
}