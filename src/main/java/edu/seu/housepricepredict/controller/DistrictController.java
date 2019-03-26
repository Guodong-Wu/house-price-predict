package edu.seu.housepricepredict.controller;

import edu.seu.housepricepredict.domain.area.District;
import edu.seu.housepricepredict.domain.area.Street;
import edu.seu.housepricepredict.domain.increase.DistrictIncrease;
import edu.seu.housepricepredict.domain.month.DistrictMonthPrice;
import edu.seu.housepricepredict.domain.year.DistrictYearPrice;
import edu.seu.housepricepredict.service.DistrictService;
import edu.seu.housepricepredict.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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

    /**
     * 根据行政区id 返回行政区年份历史房价(json)
     */
    @GetMapping("/districtYearPrice/{id}")
    @ResponseBody
    public List<DistrictYearPrice> getDistrictYearPrice(@PathVariable("id") String id) {
        return districtService.getDistrictYearPriceBydId(Integer.parseInt(id));
    }

    /**
     * 根据行政区id，返回增长率
     */
    @GetMapping("/districtIncrease/{id}")
    @ResponseBody
    public List<DistrictIncrease> getDistrictIncrease(@PathVariable("id") String id) {
        List<DistrictIncrease> list = districtService.getDistrictIncreaseBydId(Integer.parseInt(id));
        for (DistrictIncrease di : list) {
            double d = di.getIncrease();
            d *= 100;
            di.setIncrease(Double.parseDouble(String.format("%.2f", d)));
        }

        //将2019年1月、2月、3月移动到表尾
        DistrictIncrease di1 = list.get(0);
        DistrictIncrease di2 = list.get(1);
        DistrictIncrease di3 = list.get(2);
        if (di1.getMonth() < 4) {
            list.remove(di1);
            list.add(di1);
        }
        if (di2.getMonth() < 4) {
            list.remove(di2);
            list.add(di2);
        }
        if (di3.getMonth() < 4) {
            list.remove(di3);
            list.add(di3);
        }

        return list;
    }

    /**
     * 根据行政区id 返回行政区未来房价(json)
     */
    @GetMapping("/districtPredictPrice/{id}")
    @ResponseBody
    public List<DistrictMonthPrice> getDistrictPredictPrice(@PathVariable("id") String id) {
        return districtService.getDistrictPredictPriceBydId(Integer.parseInt(id));
    }

    /**
     * 根据街道名或行政区名，和城市id，查询城市信息
     */
    @GetMapping("/search/{id}")
    public String search(String keyword, @PathVariable("id") String id) {
        Street street = streetService.getStreetBysNameAndcId(keyword.trim(), Integer.parseInt(id));
        if (street == null) {
            District district = districtService.getDistrictBydNameAndcId(keyword.trim(), Integer.parseInt(id));
            if (district == null) {
                return "redirect:/notFound";
            } else {
                return "redirect:/district/"+district.getId();
            }
        } else {
            return "redirect:/street/"+street.getId();
        }
    }

    @PostMapping("/compare")
    public String compareArea(int area1, int area2, String areaLevel, Model model) {
        String areaName1 = "", areaName2 = "";
        if ("district".equals(areaLevel)) {
            areaName1 = districtService.getDistrictNameById(area1);
            areaName2 = districtService.getDistrictNameById(area2);
        } else if ("street".equals(areaLevel)) {
            areaName1 = streetService.getStreetNameById(area1);
            areaName2 = streetService.getStreetNameById(area2);
        }

        //传递区域id
        model.addAttribute("areaId1", area1);
        model.addAttribute("areaId2", area2);
        //传递区域名
        model.addAttribute("areaName1", areaName1);
        model.addAttribute("areaName2", areaName2);
        //传递地区等级
        model.addAttribute("areaLevel", areaLevel);

        return "info/lineChart";
    }
}
