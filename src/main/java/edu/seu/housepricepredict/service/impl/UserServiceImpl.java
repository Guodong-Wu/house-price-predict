package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.mapper.user.UserMapper;
import edu.seu.housepricepredict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guodonwu@163.com
 * @date 17:21 2019/3/13
 */

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
}
