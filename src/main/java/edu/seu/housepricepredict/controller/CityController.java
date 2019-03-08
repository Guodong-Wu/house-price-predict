package edu.seu.housepricepredict.controller;

import edu.seu.housepricepredict.domain.pojo.area.District;
import edu.seu.housepricepredict.domain.vo.area.CityAreaVo;
import edu.seu.housepricepredict.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    CityService cityService;

    /**
     * 返回session中存放的当前城市名
     */
    @GetMapping("/session/cityName")
    @ResponseBody
    public String getCityNameFromSession(HttpSession session) {
        System.out.println("getCityName " + session.getAttribute("cityName"));
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
        System.out.println("setCityName " + cityName);
        System.out.println("setCityId " + cId);
        return String.valueOf(cId);
    }

    /**
     * 根据城市id获取，城市及其下行政区信息
     */
    @GetMapping("city/{id}")
    @ResponseBody
    public List<District> getCityArea(@PathVariable("id") String id, String keyWord) {
        System.out.println("getCityId " + id);
        CityAreaVo cityArea = cityService.getCityAreaBycId(Integer.parseInt(id));
        List<District> districts = cityArea.getDistricts();
        System.out.println(districts);
        return districts;
    }


}
