package edu.seu.housepricepredict.service;

import edu.seu.housepricepredict.domain.pojo.area.District;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:27 2019/2/27
 * 行政区的Service接口
 */

public interface DistrictService {

    List<District> getDistrictListBycId(int cId);
}
