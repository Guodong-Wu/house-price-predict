package edu.seu.housepricepredict.mapper.month;

import edu.seu.housepricepredict.domain.increase.StreetIncrease;
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

    @Select("SELECT smp1.s_id AS id, smp1.month AS month, (smp1.price-smp2.price)/smp2.price AS increase " +
            "FROM street_month_price smp1, street_month_price smp2 " +
            "WHERE smp1.s_id = smp2.s_id AND (smp1.month - smp2.month = 1 OR (smp1.month = 1 AND smp2.month = 12)) AND smp1.month != 4 " +
            "AND smp1.s_id = #{sId}")
    List<StreetIncrease> getStreetIncreaseBysId(int sId);
}
