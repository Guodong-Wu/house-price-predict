package edu.seu.housepricepredict.service;

import edu.seu.housepricepredict.domain.area.District;
import edu.seu.housepricepredict.domain.increase.DistrictIncrease;
import edu.seu.housepricepredict.domain.month.DistrictMonthPrice;
import edu.seu.housepricepredict.domain.year.DistrictYearPrice;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:27 2019/2/27
 * 行政区的Service接口
 */

public interface DistrictService {

    List<District> getDistrictListBycId(int cId);

    String getDistrictNameById(int dId);

    List<DistrictMonthPrice> getDistrictMonthPriceBydId(int dId);

    List<DistrictYearPrice> getDistrictYearPriceBydId(int dId);

    District getDistrictBydNameAndcId(String dName, int cId);

    List<DistrictMonthPrice> getDistrictPredictPriceBydId(int dId);

    List<DistrictIncrease> getDistrictIncreaseBydId(int dId);
}
