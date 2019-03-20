package edu.seu.housepricepredict.mapper.year;

import edu.seu.housepricepredict.domain.year.StreetYearPrice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 16:25 2019/3/19
 * 街道年份房价的mapper
 */

public interface StreetYearPriceMapper {

    /**
     * 根据sid，获取指定街道的年份房价
     */
    @Select("SELECT * FROM street_year_price WHERE s_id = #{sid}")
    List<StreetYearPrice> getStreetYearPriceBysId(int sid);

    /**
     * 插入街道年份房价
     */
    @Insert("INSERT INTO street_year_price VALUES(#{sId}, #{year}, #{price})")
    int insertStreetYearPrice(StreetYearPrice streetYearPrice);
}
