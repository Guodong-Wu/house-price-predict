package edu.seu.housepricepredict.service;

import edu.seu.housepricepredict.domain.area.Street;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:30 2019/2/27
 * 街道的Service接口
 */

public interface StreetService {

    List<Street> getStreetListBydId(int dId);
}
