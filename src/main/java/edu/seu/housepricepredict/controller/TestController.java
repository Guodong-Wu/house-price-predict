package edu.seu.housepricepredict.controller;

import edu.seu.housepricepredict.domain.Value;
import edu.seu.housepricepredict.domain.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author xg_song
 * @data 2019/3/11 10:32
 */
@Controller
public class TestController {


    /**
     * 获取表单选择的两个城市名，并跳转到折线图页面。
     * @param commName1
     * @param commName2
     * @return
     */
    @RequestMapping(value = "/lineChart")
    public String toComparePage(String commName1,  String commName2, Model model){
        model.addAttribute("commName1", commName1);
        model.addAttribute("commName2", commName2);
        return "info/lineChart";
    }

    @RequestMapping("/choose")
    public String chooseCity(){
        return "choose";
    }

    /**
     * 返回该区域内小区列表
     * @return
     */
    @RequestMapping("/getCityNames")
    @ResponseBody
    public String[] getCityNames(){
        String [] cityNames = {"1", "2", "3", "4"};
        return cityNames;
    }

    /**
     * 取出两个小区名，并将小区历史房价放入Value数组传到页面
     * Value属性：
     *          dataOfx:横坐标数据---时间
     *          dataOfy1:纵坐标数据---小区1房价
     *          dataOfy2：纵坐标数据---小区2房价
     * @param request
     * @return
     */
    @RequestMapping("/getPriceOfComm")
    @ResponseBody
    public Value[] getPriceOfComm(HttpServletRequest request){
        //小区名一：commName1, 小区名二：commName2
        String commName1 = request.getParameter("comm1");
        String commName2 = request.getParameter("comm2");
        Value [] values = new Value[8];
        for(int i = 0; i < 8; i++){
            values[i] = new Value(i + "", i + "", i + 2 + "");
        }
        return values;
    }

    /**
     * 获取要对比小区所在城市并返回
     * @return
     */
    @RequestMapping("/getCityName")
    @ResponseBody
    public String[] getCityName(){
        String cityName[] = {"苏州市"};
        System.out.println("getCityName " + cityName[0]);

        return cityName;
    }

    /**
     * 获取要对比小区所在区域和街道并返回。
     * @return
     */
    @RequestMapping("/getAddress")
    @ResponseBody
    public String[] getAddress(){
        String address[] = new String[1];
//        address[0] = "吴中区文荟人才公寓";
        address[0] = "吴中区文星广场";
        System.out.println("getAddress " + address[0]);
        return address;
    }

    /**
     * 查询用户是否登录，若登录则返回用户信息，否则返回空
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Integer getUserInfo(){
        User user = null;
        user = new User();
        user.setUserId(1);
        int userId = user.getUserId();
        System.out.println("get User info--user: " + user);
        return userId;
//        return -1;
    }

    /**
     * 传入参数为用户id，然后获取用户信息，最后进入表单页面并进行信息回显
     * @param userId
     * @param user
     * @return
     */
    @RequestMapping("/edit/{userId}")
    public String eidtInfo(@PathVariable("userId") Integer userId, User user){
        System.out.println("userId: " + userId);
        user.setUserId(userId);
        user.setUserName("song");
        user.setUserPassword("123456");
        user.setUserEmail("song@163.com");
        System.out.println(user);
        return "user/updateUserInfo";
    }

    /**
     * 修改用户信息：在前台已经对数据进行验证（用户名、密码、邮箱不为空，两次密码一致，邮箱符合标准），
     * 只需将传入数据保存返回首页即可
     * @param userId
     * @param user
     * @return
     */
    @RequestMapping("/update/{userId}")
    public String updateInfo(@PathVariable("userId") Integer userId, User user){
        System.out.println("update user info");
        System.out.println(user);
        return "index";
    }


    /**
     * 用户修改信息
     * 验证用户信息若用户信息通过，则返回首页，否则返回登录页
     * @param user
     * @return
     */
    @RequestMapping("/userVerify")
    public String userVerify(User user, HttpSession session){
        System.out.println("user: " + user);
        user.setUserId(1);
        session.setAttribute("user", user);
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "user/register";
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/userRegister")
    public String userRegister(User user){
        System.out.println("user: " + user);
        return "index";
    }

    /**
     * 用户退出后返回主页面
     * @return
     */
    @RequestMapping("/quit")
    public String userQuit(){
        System.out.println("quit--");
        return "index";
    }
}
