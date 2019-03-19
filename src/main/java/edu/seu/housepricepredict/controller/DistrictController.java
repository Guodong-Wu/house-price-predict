package edu.seu.housepricepredict.controller;

import edu.seu.housepricepredict.domain.area.Street;
import edu.seu.housepricepredict.domain.month.DistrictMonthPrice;
import edu.seu.housepricepredict.service.DistrictService;
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
 * @date 14:35 2019/3/11
 * 行政区的Controller
 */
@Controller
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private StreetService streetService;

    /**
     * 跳转至显示页面，并将行政区id和行政区名传过去
     */
    @GetMapping("/district/{id}")
    public String showDistrictInfo(@PathVariable("id") String id, Model model) {
        String dName = districtService.getDistrictNameById(Integer.parseInt(id));

        //传递行政区id
        model.addAttribute("areaId", id);
        //传递行政区名
        model.addAttribute("areaName", dName);
        //传递地区等级
        model.addAttribute("areaLevel", "district");

        return "info/showInfo";
    }

    /**
     * 根据行政区id，返回行政区下的街道(json)
     */
    @GetMapping("/districtArea/{id}")
    @ResponseBody
    public List<Street> getStreetListBydId(@PathVariable("id") String id) {
        return streetService.getStreetListBydId(Integer.parseInt(id));
    }

    /**
     * 根据行政区id，返回行政区每月历史房价(json)
     */
    @GetMapping("/districtMonthPrice/{id}")
    @ResponseBody
    public List<DistrictMonthPrice> getDistrictMonthPrice(@PathVariable("id") String id) {
        List<DistrictMonthPrice> monthPriceList = districtService.getDistrictMonthPriceBydId(Integer.parseInt(id));

        //将2019年1月、2月、3月移动到表尾
        DistrictMonthPrice dmp1 = monthPriceList.get(0);
        DistrictMonthPrice dmp2 = monthPriceList.get(1);
        DistrictMonthPrice dmp3 = monthPriceList.get(2);
        if (dmp1.getMonth() < 4) {
            monthPriceList.remove(dmp1);
            monthPriceList.add(dmp1);
        }
        if (dmp2.getMonth() < 4) {
            monthPriceList.remove(dmp2);
            monthPriceList.add(dmp2);
        }
        if (dmp3.getMonth() < 4) {
            monthPriceList.remove(dmp3);
            monthPriceList.add(dmp3);
        }

        return monthPriceList;
    }
}
