package edu.seu.housepricepredict.controller;

import edu.seu.housepricepredict.domain.user.User;
import edu.seu.housepricepredict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author guodonwu@163.com
 * @date 14:42 2019/3/16
 * User的controller
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 判断用户名是否存在
     */
    @PostMapping("/isExistByUserName")
    @ResponseBody
    public String isExistByUserName(String userName) {
        User user =  userService.getUserByName(userName);
        if (user == null) {
            return "no";
        } else {
            return user.toString();
        }
    }

    /**
     * 判断用户邮箱是否存在
     */
    @PostMapping("/isExistByUserEmail")
    @ResponseBody
    public String isExistByUserEmail(String userEmail) {
        User user =  userService.getUserByEmail(userEmail);
        if (user == null) {
            return "no";
        } else {
            return user.toString();
        }
    }

    /**
     * 来到修改页面
     */
    @GetMapping("/user/{id}")
    public String updateUser() {
        return "user/updateUserInfo";
    }

    /**
     * 修改员工
     */
    @PutMapping("/user/{id}")
    public String updateUser(User user, HttpServletRequest request) {
        userService.updateUser(user);
        request.getSession().setAttribute("user", user);
        request.setAttribute("msg", "修改成功，请重新登录");
        return "user/login";
    }

}
