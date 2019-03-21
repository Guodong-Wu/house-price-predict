package edu.seu.housepricepredict.controller;

import edu.seu.housepricepredict.domain.area.Community;
import edu.seu.housepricepredict.domain.month.StreetMonthPrice;
import edu.seu.housepricepredict.domain.year.StreetYearPrice;
import edu.seu.housepricepredict.service.CommunityService;
import edu.seu.housepricepredict.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 14:10 2019/3/14
 * 街道的Controller
 */
@Controller
public class StreetController {
    @Autowired
    private StreetService streetService;

    @Autowired
    private CommunityService communityService;

    /**
     * 跳转至显示页面，并将街道id和街道名传过去
     */
    @GetMapping("/street/{id}")
    public String showStreetInfo(@PathVariable("id")String id, Model model) {
        String sName = streetService.getStreetNameById(Integer.parseInt(id));

        //传递街道id
        model.addAttribute("areaId", id);
        //传递街道名
        model.addAttribute("areaName", sName);
        //传递地区等级
        model.addAttribute("areaLevel", "street");

        return "info/showInfo";
    }

    /**
     * 根据街道id，返回街道下所有的小区(json)
     */
    @GetMapping("/streetArea/{id}")
    @ResponseBody
    public List<Community> getCommunityListBysId(@PathVariable("id") String id) {
        return communityService.getCommunityListBysId(Integer.parseInt(id));
    }

    /**
     * 根据街道id，返回街道每月的历史房价(json)
     */
    @GetMapping("/streetMonthPrice/{id}")
    @ResponseBody
    public List<StreetMonthPrice> getStreetMonthPrice(@PathVariable("id") String id) {
        List<StreetMonthPrice> monthPriceList = streetService.getStreetMonthPriceBysId(Integer.parseInt(id));

        //将2019年1月和2月移动到表尾
        StreetMonthPrice smp1 = monthPriceList.get(0);
        StreetMonthPrice smp2 = monthPriceList.get(1);
        StreetMonthPrice smp3 = monthPriceList.get(2);
        if (smp1.getMonth() < 4) {
            monthPriceList.remove(smp1);
            monthPriceList.add(smp1);
        }
        if (smp2.getMonth() < 4) {
            monthPriceList.remove(smp2);
            monthPriceList.add(smp2);
        }
        if (smp3.getMonth() < 4) {
            monthPriceList.remove(smp3);
            monthPriceList.add(smp3);
        }


        return monthPriceList;
    }

    /**
     * 根据街道id 返回街道年份历史房价(json)
     */
    @GetMapping("/streetYearPrice/{id}")
    @ResponseBody
    public List<StreetYearPrice> getStreetYearPrice(@PathVariable("id") String id) {
        return streetService.getStreetYearPriceBysId(Integer.parseInt(id));
    }

}
