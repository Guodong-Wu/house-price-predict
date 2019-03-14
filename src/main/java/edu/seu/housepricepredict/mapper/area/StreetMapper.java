package edu.seu.housepricepredict.mapper.area;

import edu.seu.housepricepredict.domain.area.Street;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:12 2019/2/27
 * 街道的Mapper接口
 */

public interface StreetMapper {

    /**
     * 根据行政区id，查找街道列表
     */
    @Select("SELECT id, name, price FROM street WHERE d_id = #{dId}")
    List<Street> getStreetListBydId(int dId);

    /**
     * 根据街道名和行政区id，查询街道id
     */
    @Select("SELECT id FROM street WHERE name = #{sName} AND d_id = #{dId}")
    int getsIdBysNameAnddId(@Param("sName")String sName, @Param("dId")int dId);

    /**
     * 根据街道id，返回街道名
     */
    @Select("SELECT name FROM street WHERE id = #{sId}")
    String getStreetNameById(int sId);

    /**
     * 插入街道信息
     */
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Insert("INSERT INTO street(name, d_id) VALUES(#{sName}, #{dId})")
    int insertStreet(@Param("sName")String sName, @Param("dId")int dId);

    /**
     * 更新街道当前月房价
     */
    @Update("UPDATE street s SET s.price = " +
            "(SELECT smp.price FROM street_month_price smp WHERE s.id = smp.s_id AND month = #{month})")
    int updateStreetPrice(int month);
}
