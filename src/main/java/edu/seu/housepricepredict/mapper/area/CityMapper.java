package edu.seu.housepricepredict.mapper.area;


import edu.seu.housepricepredict.domain.area.City;
import org.apache.ibatis.annotations.*;

/**
 * @author guodonwu@163.com
 * @date 10:01 2019/2/27
 * 城市的Mapper接口
 */

public interface CityMapper {

    /**
     * 根据城市id，查询城市信息
     */
    @Select("SELECT name FROM city WHERE id = #{cId}")
    String getCityNameBycId(int cId);

    /**
     * 根据城市名，获取城市id
     */
    @Select("SELECT id FROM city WHERE name = #{cName}")
    int getCityIdBycName(String cName);

    /**
     * 根据城市名，获取城市
     */
    @Select("SELECT * FROM city WHERE name = #{cName}")
    City getCityBycName(String cName);

    /**
     * 插入城市信息
     */
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Insert("INSERT INTO city(name) values(#{cName})")
    int insertCity(String cName);

    /**
     * 更新城市当前月的房价
     */
    @Update("UPDATE city c SET c.price = " +
            "(SELECT cmp.price FROM city_month_price cmp WHERE c.id = cmp.c_id AND month = #{month})")
    int updateCityPrice(int month);


}
