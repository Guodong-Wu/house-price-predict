package edu.seu.housepricepredict.controller;

import com.github.pagehelper.PageInfo;
import edu.seu.housepricepredict.domain.user.User;
import edu.seu.housepricepredict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    /**
     * 来到用户列表页面,查询用户信息
     */
    @GetMapping("/users/{currentPage}")
    public String getUserList(@PathVariable("currentPage") String currentPage, ModelMap map) {
        PageInfo<User> pageInfo = userService.getUserList(Integer.parseInt(currentPage));
        map.put("pageInfo", pageInfo);
        return "user/userList";
    }

    /**
     * 根据用户名，查询用户信息
     */
    @GetMapping("/select")
    public String getUserPageByName(String userName, ModelMap map) {
        PageInfo<User> pageInfo = userService.getUserPageByName(1, userName);
        map.put("pageInfo", pageInfo);
        map.put("isAll", "no");
        return "user/userList";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id") String id, ModelMap map) {
        userService.deleteUserById(Integer.parseInt(id));
        PageInfo pageInfo = userService.getUserList(1);
        map.put("pageInfo", pageInfo);
        return "redirect:/users/1";
    }

}
