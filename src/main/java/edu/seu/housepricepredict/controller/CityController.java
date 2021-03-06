package edu.seu.housepricepredict.controller;

import edu.seu.housepricepredict.domain.area.District;
import edu.seu.housepricepredict.domain.month.CityMonthPrice;
import edu.seu.housepricepredict.domain.year.CityYearPrice;
import edu.seu.housepricepredict.service.CityService;
import edu.seu.housepricepredict.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 14:49 2019/3/8
 */

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;

    /**
     * 返回session中存放的当前城市名
     */
    @GetMapping("/session/cityName")
    @ResponseBody
    public String getCityNameFromSession(HttpSession session) {

        return (String) session.getAttribute("cityName");
    }

    /**
     * 将城市名传入到session中
     */
    @PostMapping("/session/cityName")
    @ResponseBody
    public String setCityNameToSession(String cityName, HttpSession session) {
        cityName = cityName.substring(0, cityName.length()-1);
        int cId = cityService.getCityIdBycName(cityName);
        session.setAttribute("cityName", cityName);
        session.setAttribute("cityId", cId);
        return String.valueOf(cId);
    }

    /**
     * 根据城市id，返回城市下的行政区(json)
     */
    @GetMapping("/cityArea/{id}")
    @ResponseBody
    public List<District> getDistrictListBycId(@PathVariable("id") String id) {
        return districtService.getDistrictListBycId(Integer.parseInt(id));
    }

    /**
     * 根据城市id 返回城市每月历史房价(json)
     */
    @GetMapping("/cityMonthPrice/{id}")
    @ResponseBody
    public List<CityMonthPrice> getCityMonthPrice(@PathVariable("id") String id) {
        List<CityMonthPrice> monthPriceList = cityService.getCityMonthPriceBycId(Integer.parseInt(id));

        //将2019年1月、2月、3月，移动到表末尾
        CityMonthPrice cmp1 = monthPriceList.get(0);
        CityMonthPrice cmp2 = monthPriceList.get(1);
        CityMonthPrice cmp3 = monthPriceList.get(2);
        if (cmp1.getMonth() < 4) {
            monthPriceList.remove(cmp1);
            monthPriceList.add(cmp1);
        }
        if (cmp2.getMonth() < 4) {
            monthPriceList.remove(cmp2);
            monthPriceList.add(cmp2);
        }
        if (cmp3.getMonth() < 4) {
            monthPriceList.remove(cmp3);
            monthPriceList.add(cmp3);
        }


        return monthPriceList;
    }

    /**
     * 根据城市id 返回城市年份历史房价(json)
     */
    @GetMapping("/cityYearPrice/{id}")
    @ResponseBody
    public List<CityYearPrice> getCityYearPrice(@PathVariable("id") String id) {
        return cityService.getCityYearPriceBycId(Integer.parseInt(id));
    }

    /**
     * 根据城市id 返回城市未来房价(json)
     */
    @GetMapping("/cityPredictPrice/{id}")
    @ResponseBody
    public List<CityMonthPrice> getCityPredictPrice(@PathVariable("id") String id) {
        return cityService.getCityPredictPriceBycId(Integer.parseInt(id));
    }

    /**
     * 跳转至显示页面，并将城市id和城市名传过去
     */
    @GetMapping("/city/{id}")
    public String showCityInfo(@PathVariable("id") String id, String keyword, Model model) {
        if (!keyword.trim().equals("")) {
            return "forward:/search/"+id;
        }

        String cName = cityService.getCityNameBycId(Integer.parseInt(id));
        //将城市传到前端页面
        model.addAttribute("areaId", id);
        //将城市名传到前端页面
        model.addAttribute("areaName", cName);
        //传递地区等级
        model.addAttribute("areaLevel", "city");

        return "info/showInfo";
    }


}
