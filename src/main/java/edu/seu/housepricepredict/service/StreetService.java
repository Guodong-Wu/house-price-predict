package edu.seu.housepricepredict.service;

import edu.seu.housepricepredict.domain.area.Street;
import edu.seu.housepricepredict.domain.increase.StreetIncrease;
import edu.seu.housepricepredict.domain.month.StreetMonthPrice;
import edu.seu.housepricepredict.domain.year.StreetYearPrice;

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

    List<StreetYearPrice> getStreetYearPriceBysId(int sId);

    Street getStreetBysNameAndcId(String sName, int cId);

    List<StreetMonthPrice> getStreetPredictPriceBysId(int sId);

    List<StreetIncrease> getStreetIncreaseBysId(int sId);
}
