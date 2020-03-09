package com.mininote.user.service.impl;

import com.mininote.user.dao.UserMapper;
import com.mininote.user.pojo.User;
import com.mininote.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author 张某
 * @DATE 2020/2/27
 * @parent mininote_parent
 * @description com.mininote.user.service.impl
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     * @param user
     */
    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    /**
     * 查询用户
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (StringUtils.isNotBlank(username)) {
//            criteria.andEqualTo("username", username);
//        }
//        return userMapper.selectOneByExample(example);
        return userMapper.selectByPrimaryKey(username);
    }
}
