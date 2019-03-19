package edu.seu.housepricepredict.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.seu.housepricepredict.domain.user.User;
import edu.seu.housepricepredict.mapper.user.UserMapper;
import edu.seu.housepricepredict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 17:21 2019/3/13
 * user的service接口实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserByNameAndPassword(User user) {
        return userMapper.getUserByNameAndPassword(user);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return userMapper.getUserByEmail(userEmail);
    }

    public PageInfo getUserList(int pageNo){
        PageHelper.startPage(pageNo, 10);
        List<User> list = userMapper.getUserList();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
