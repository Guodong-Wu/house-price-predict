package edu.seu.housepricepredict.mapper.year;

import edu.seu.housepricepredict.domain.year.DistrictYearPrice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 16:25 2019/3/19
 * 行政区年份房价
 */

public interface DistrictYearPriceMapper {

    /**
     * 从其他表获取行政区的年份房价
     */
    @Select("SELECT d_id, year, AVG(syp.price) AS price FROM street s, street_year_price syp " +
            "WHERE s.id = syp.s_id GROUP BY d_id, year")
    List<DistrictYearPrice> getDistrictYearPriceFromOthers();

    /**
     * 根据did，获取指定行政区的每年房价
     */
    @Select("SELECT * FROM district_year_price WHERE d_id = #{dId}")
    List<DistrictYearPrice> getDistrictYearPriceBydId(int dId);

    /**
     * 插入行政区每年的平均房价
     */
    @Insert("INSERT INTO district_year_price VALUES(#{dId}, #{year}, #{price})")
    int insertDistrictYearPrice(DistrictYearPrice districtYearPrice);
}
