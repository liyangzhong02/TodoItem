package org.marre.webapplication.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.marre.webapplication.mapper.UserMapper;
import org.marre.webapplication.model.User;
import org.marre.webapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :marRE
 * @Description:
 * @Date :2024/5/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User Login(User user) {

        // 登录逻辑：根据用户名和密码查询用户
        User foundUser = userMapper.selectOne(new QueryWrapper<User>().eq("name", user.getName()).eq("pwd", user.getPwd()));
        if(foundUser != null){
            return foundUser;
        }else{
            throw new IllegalArgumentException("check username or pwd!");
        }

    }

    @Override
    public User addUser(User user) {
        User existUser = userMapper.selectOne(new QueryWrapper<User>().eq("name",user.getName()));
        if (existUser == null){
            userMapper.insert(user);
            return user;
        }else{
            throw new IllegalArgumentException("Username already exists");
        }
    }

    @Override
    public User delUser(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (user.getId() != null) {
            queryWrapper.eq("id", user.getId());
        } else if (user.getName() != null) {
            queryWrapper.eq("name", user.getName());
        }
        int deleteCount = userMapper.delete(queryWrapper);
        return deleteCount > 0 ? user : null;
    }

    @Override
    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
