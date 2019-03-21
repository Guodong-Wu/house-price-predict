package edu.seu.housepricepredict.controller;

import edu.seu.housepricepredict.domain.user.User;
import edu.seu.housepricepredict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author guodonwu@163.com
 * @date 15:52 2019/3/13
 * 登录功能的controller
 */

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 来到用户登录页
     */
    @GetMapping("/user/login")
    public String userLogin() {
        return "user/login";
    }

    /**
     * 验证用户信息
     * 若用户信息未通过，返回登录页
     * 若用户信息通过
     *      若用户是管理员，则进入管理员页面
     *      若是普通用户，则返回首页
     */
    @PostMapping("/user/login")
    public String userLogin(User user, HttpServletRequest request) {
        User u = userService.getUserByNameAndPassword(user);
        //用户登录失败
        if (u == null) {
            request.setAttribute("msg", "用户名或密码错误");
            return "user/login";
        } else {
            //用户登录成功,如果是管理员，则进入后台管理页面
            if (u.getIsAdmin() == 1) {
                request.getSession().setAttribute("user", u);
                //为防止表单重复提交, 重定向，需要在配置类中配置视图映射
                return "redirect:/users/1";
            } else {
                //如果是普通用户，则返回首页，并保存到session中
                request.getSession().setAttribute("user", u);
                //为防止表单重复提交, 重定向，需要在配置类中配置视图映射
                return "redirect:/index";
            }
        }
    }

    /**
     * 来到用户注册页面
     */
    @GetMapping("/user/register")
    public String userRegister() {
        return "user/register";
    }

    /**
     * 用户注册
     */
    @PostMapping("/user/register")
    public String userRegister(User user, HttpServletRequest request) {
        if (user == null) {
            return "redirect:/user/register";
        } else {
            userService.insertUser(user);
            request.setAttribute("msg", "注册成功，请登录");
            return "user/login";
        }
    }


    /**
     * 获取session中user
     */
    @GetMapping("/session/user")
    @ResponseBody
    public User getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new User();
        } else {
            return user;
        }
    }

    /**
     * 退出登录
     */
    @GetMapping("/user/quit")
    public String userQuit(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/index";
    }
}