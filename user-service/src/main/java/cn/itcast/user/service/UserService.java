package cn.itcast.user.service;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xualin
 * @version v1.0
 * @date 2019/4/2 11:45
 * @description
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
