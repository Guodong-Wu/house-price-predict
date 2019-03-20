package edu.seu.housepricepredict.mapper.year;

import edu.seu.housepricepredict.domain.year.CityYearPrice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 15:18 2019/3/19
 * 城市年份房价
 */

public interface CityYearPriceMapper {

    /**
     * 从其他表获取所有城市每年房价
     */
    @Select("SELECT c_id, year, AVG(dyp.price) AS price FROM district d, district_year_price dyp " +
            "WHERE d.id = dyp.d_id GROUP BY c_id, year")
    List<CityYearPrice> getCityYearPriceFromOthers();

    /**
     * 根据cid，获取指定城市每年房价
     */
    @Select("SELECT * FROM city_year_price WHERE c_id = #{cId}")
    List<CityYearPrice> getCityYearPriceBycId(int cId);

    /**
     * 插入城市每年房价
     */
    @Insert("INSERT INTO city_year_price VALUES(#{cId}, #{year}, #{price})")
    int insertCityYearPrice(CityYearPrice cityYearPrice);
}
