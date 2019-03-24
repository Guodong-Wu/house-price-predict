package edu.seu.housepricepredict.mapper.month;

import edu.seu.housepricepredict.domain.increase.DistrictIncrease;
import edu.seu.housepricepredict.domain.month.DistrictMonthPrice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 14:53 2019/3/5
 * 行政区月份房价Mapper
 */

public interface DistrictMonthPriceMapper {

    /**
     * 从其他表获取行政区每月房价
     */
    @Select("SELECT d_id, month, AVG(smp.price) AS price FROM street s, street_month_price smp " +
            "WHERE s.id = smp.s_id GROUP BY d_id, month")
    List<DistrictMonthPrice> getDistrictMonthPriceFromOthers();

    /**
     * 根据did，获取指定行政区的每月房价
     */
    @Select("SELECT * FROM district_month_price WHERE d_id = #{dId}")
    List<DistrictMonthPrice> getDistrictMonthPriceBydId(int dId);

    /**
     * 插入行政区每个月的平均房价
     */
    @Insert("INSERT INTO district_month_price VALUES(#{dId}, #{month}, #{price})")
    int insertDistrictMonthPrice(DistrictMonthPrice districtMonthPrice);

    /**
     * 从其他表获取行政区未来房价
     */
    @Select("SELECT d_id, month, AVG(spp.price) AS price FROM street s, street_predict_price spp " +
            "WHERE s.id = spp.s_id GROUP BY d_id, month")
    List<DistrictMonthPrice> getDistrictPredictPriceFromOthers();

    /**
     * 根据did，获取指定行政区的未来房价
     */
    @Select("SELECT * FROM district_predict_price WHERE d_id = #{dId}")
    List<DistrictMonthPrice> getDistrictPredictPriceBydId(int dId);

    /**
     * 插入行政区每个月的未来房价
     */
    @Insert("INSERT INTO district_predict_price VALUES(#{dId}, #{month}, #{price})")
    int insertDistrictPredictPrice(DistrictMonthPrice districtMonthPrice);

    @Select("SELECT dmp1.d_id AS id, dmp1.month AS month, (dmp1.price-dmp2.price)/dmp2.price AS increase " +
            "FROM district_month_price dmp1, district_month_price dmp2 " +
            "WHERE dmp1.d_id = dmp2.d_id AND (dmp1.month - dmp2.month = 1 OR (dmp1.month = 1 AND dmp2.month = 12)) AND dmp1.month != 4 " +
            "AND dmp1.d_id = #{dId}")
    List<DistrictIncrease> getDistrictIncreaseBydId(int dId);

}
