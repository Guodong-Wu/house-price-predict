package edu.seu.housepricepredict.service;

import edu.seu.housepricepredict.domain.vo.area.CityAreaVo;

/**
 * @author guodonwu@163.com
 * @date 10:27 2019/2/27
 * 城市的Service接口
 */

public interface CityService {

    int getCityIdBycName(String cName);
    CityAreaVo getCityAreaBycId(int cId);

}
