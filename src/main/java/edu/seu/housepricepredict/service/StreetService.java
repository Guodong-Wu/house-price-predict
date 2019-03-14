package edu.seu.housepricepredict.service;

import edu.seu.housepricepredict.domain.area.Street;
import edu.seu.housepricepredict.domain.month.StreetMonthPrice;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:30 2019/2/27
 * 街道的Service接口
 */

public interface StreetService {

    List<Street> getStreetListBydId(int dId);
    String getStreetNameById(int sId);
    List<StreetMonthPrice> getStreetMonthPriceBysId(int sId);
}
