package edu.seu.housepricepredict.mapper.month;

import edu.seu.housepricepredict.domain.pojo.month.DistrictMonthPrice;
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
    @Select("SELECT d_id, month, AVG(price) AS price FROM street s, street_month_price smp " +
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

}
