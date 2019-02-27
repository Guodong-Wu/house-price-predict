package edu.seu.housepricepredict.mapper;

import edu.seu.housepricepredict.pojo.area.District;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:01 2019/2/27
 * 城市的Mapper接口
 */

public interface CityMapper {

    /**
     *
     * @return
     */
    List<District> getDistrictsBycId();
}
