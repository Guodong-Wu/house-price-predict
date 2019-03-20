package edu.seu.housepricepredict.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.seu.housepricepredict.domain.Value;
import edu.seu.housepricepredict.domain.user.User;
import edu.seu.housepricepredict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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









    @Autowired
    private UserService userService;


//    /**
//     *  查询用户信息并进入用户管理界面
//     * @param map
//     * @return
//     */
//    @RequestMapping("/touserList/{pageNo}")
//    public String toUserList(@PathVariable(value = "pageNo") int pageNo, ModelMap map) {
//        PageInfo pageInfo = userService.getUserList(pageNo);
//        System.out.println("userList=======");
//        map.put("pageInfo", pageInfo);
//        return "user/userList";
//    }
//
//    /**
//     * 根据传来的用户名关键词进行查询并将结果返回
//     * @param key
//     * @param map
//     * @return
//     */
//    @RequestMapping("/select/{key}")
//    public String select(@PathVariable("key") String key, ModelMap map){
//
//        PageInfo pageInfo = userService.getUserList(1);
//        map.put("pageInfo", pageInfo);
//        return "user/userList";
//    }
    @RequestMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") String userId, ModelMap map){
        System.out.println("删除用户");
        PageInfo pageInfo = userService.getUserList(1);
        map.put("pageInfo", pageInfo);
        return "user/userList";
    }




}
