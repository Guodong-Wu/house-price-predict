package edu.seu.housepricepredict.service;

import edu.seu.housepricepredict.domain.month.CityMonthPrice;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:27 2019/2/27
 * 城市的Service接口
 */

public interface CityService {

    int getCityIdBycName(String cName);

    List<CityMonthPrice> getCityMonthPriceBycId(int cId);

    String getCityNameBycId(int cId);

}
