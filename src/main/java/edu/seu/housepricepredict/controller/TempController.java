package edu.seu.housepricepredict.controller;

import edu.seu.housepricepredict.domain.pojo.ValueOfxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.Queue;

@Controller
public class TempController {

    // ----------将城市名传入Session。参数cityName，请求url为setCityName
    @RequestMapping("/setCityName")
    public void setCityName(@RequestBody String cityName){

    }

    // ----------城市名改变，将城市名传入Session。参数cityName，请求url为changeCityName
    @RequestMapping("/changeCityName")
    public void changeCityName(@RequestBody String cityName){

    }


    // 查询Session中城市名是否为空，若城市名为空，则进行城市查询,
    // 访问URL：getCityNameOfSession。返回值为true表示已有城市名，无需定位,城市名不存在则返回false
    @RequestMapping("/getCityNameOfSession")
    public Boolean getCityNameOfSession(){

        return false;
    }

    //搜索功能：访问URL：/searchCity   城市名在session中获取  搜索关键词keyWord
    @RequestMapping("/searchCity")
    public String search(){

        return "";
    }

    // 根据搜索结果获取其下一级区域的名字和平均房价，访问URL为：“/getPricesandNames”
    //返回值类型为地区名与房价数组ValueOfxy[]其中 ValueOfxy(String name, Integer price)name为地区名，price为平均房价
    @RequestMapping("/getPricesandNames")
    public ValueOfxy [] getPricesandNames(){
        Queue queue = new LinkedList();
        ((LinkedList) queue).push(new Integer(1));
        return null;
    }

    // 获取热门房市（可以暂取房价前五）,返回值为城市名数组 访问URL：/getHotCity
    @RequestMapping("/getHotCity")
    public String [] getHotCity(){
        return null;
    }

    // 获取城市名，即要显示哪个区域的柱状图 访问URL：/getCityName 返回值为城市名
    @RequestMapping("/getCityName")
    public String getCityName(){
        return "";
    }

}
