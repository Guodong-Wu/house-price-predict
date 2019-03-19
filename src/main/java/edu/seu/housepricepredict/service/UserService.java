package edu.seu.housepricepredict.service;

import com.github.pagehelper.PageInfo;
import edu.seu.housepricepredict.domain.user.User;

import java.util.List;


/**
 * @author guodonwu@163.com
 * @date 17:20 2019/3/13
 * user的service接口
 */

public interface UserService {

    User getUserByNameAndPassword(User user);

    int insertUser(User user);

    User getUserByName(String userName);

    User getUserByEmail(String userEmail);

    PageInfo getUserList(int pageNo);
}
