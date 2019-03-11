package edu.seu.housepricepredict.mapper.area;

import edu.seu.housepricepredict.domain.area.District;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:11 2019/2/27
 * 行政区的Mapper接口
 */

public interface DistrictMapper {

    /**
     * 根据城市id，查找行政区列表
     */
    @Select("Select id, name, price FROM district WHERE c_id = #{cId}")
    List<District> getDistrictListBycId(int cId);

    /**
     * 根据行政区id，查询行政区名
     */
    @Select("SELECT name FROM district WHERE id = #{dId}")
    String getDistrictNameById(int dId);

    /**
     * 根据行政区名和城市id，查询行政区id
     */
    @Select("SELECT id FROM district WHERE name = #{dName} AND c_id = #{cId}")
    int getdIdBydNameAndcId(@Param("dName")String dName, @Param("cId")int cId);

    /**
     * 插入行政区信息
     */
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Insert("INSERT INTO district(name, c_id) VALUES(#{dName}, #{cId})")
    int insertDistrict(@Param("dName")String dName, @Param("cId")int cId);

    /**
     * 更新行政区当前月房价
     */
    @Update("UPDATE district d SET d.price = " +
            "(SELECT dmp.price FROM district_month_price dmp WHERE d.id = dmp.d_id AND month = #{month})")
    int updateDistrictPrice(int month);
}
