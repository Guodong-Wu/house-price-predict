package edu.seu.housepricepredict.mapper.month;

import edu.seu.housepricepredict.domain.pojo.month.CityMonthPrice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 14:24 2019/3/5
 * 城市月份房价的Mapper
 */

public interface CityMonthPriceMapper {

    /**
     * 从其他表获取所有城市每月房价
     */
    @Select("SELECT c_id, month, AVG(price) AS price FROM district d, district_month_price dmp " +
            "WHERE d.d_id = dmp.d_id GROUP BY c_id, month")
    List<CityMonthPrice> getCityMonthPriceFromOnthers();

    /**
     * 根据cid，获取指定城市每月房价
     */
    @Select("SELECT * FROM city_month_price WHERE c_id = #{cId}")
    List<CityMonthPrice> getCityMonthPriceBycId(int cId);

    /**
     * 插入城市每月房价
     */
    @Insert("INSERT INTO city_month_price VALUES(#{cId}, #{month}, #{price})")
    int insertCityMonthPrice(CityMonthPrice cityMonthPrice);

}