package com.lny.bbs.dao;

import com.lny.bbs.pojo.User;

public interface UserMapper {

    User selectByUserId(Integer id);

}