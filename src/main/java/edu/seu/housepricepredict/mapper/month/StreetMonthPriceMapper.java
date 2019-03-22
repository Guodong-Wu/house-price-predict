package edu.seu.housepricepredict.mapper.month;

import edu.seu.housepricepredict.domain.month.StreetMonthPrice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 15:14 2019/3/5
 * 街道月份房价Mapper
 */

public interface StreetMonthPriceMapper {

    /**
     * 根据sid，获取指定街道的每月房价
     */
    @Select("SELECT * FROM street_month_price WHERE s_id = #{sId}")
    List<StreetMonthPrice> getStreetMonthPriceBysId(int sId);

    /**
     * 插入街道每月房价
     */
    @Insert("INSERT INTO street_month_price VALUES(#{sId}, #{month}, #{price})")
    int insertStreetMonthPrice(StreetMonthPrice streetMonthPrice);

    /**
     * 根据sid，获取指定街道的未来房价
     */
    @Select("SELECT * FROM street_predict_price WHERE s_id = #{sId}")
    List<StreetMonthPrice> getStreetPredictPriceBysId(int sId);

    /**
     * 插入街道未来房价
     */
    @Insert("INSERT INTO street_predict_price VALUES(#{sId}, #{month}, #{price})")
    int insertStreetPredictPrice(StreetMonthPrice streetMonthPrice);
}
