package edu.seu.housepricepredict.service;

import edu.seu.housepricepredict.domain.pojo.area.City;
import edu.seu.housepricepredict.domain.pojo.month.CityMonthPrice;
import edu.seu.housepricepredict.domain.vo.area.CityAreaVo;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:27 2019/2/27
 * 城市的Service接口
 */

public interface CityService {

    int getCityIdBycName(String cName);

    CityAreaVo getCityAreaBycId(int cId);

    List<CityMonthPrice> getCityMonthPriceBycId(int cId);

    City getCityBycId(int cId);

}
