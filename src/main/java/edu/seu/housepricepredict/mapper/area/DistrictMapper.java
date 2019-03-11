package edu.seu.housepricepredict.mapper.area;

import edu.seu.housepricepredict.domain.pojo.area.District;
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

//    /**
//     * 根据行政区id 查询行政区信息以及其下的街道
//     */
//    @Select("Select d_id, d_name, d_price FROM district WHERE d_id = #{dId}")
//    @Results({
//            @Result(id = true, column ="d_id", property = "dId"),
//            @Result(column = "d_id", property = "streets", javaType = List.class,
//                    many = @Many(
//                            select = "edu.seu.housepricepredict.mapper.area.StreetMapper.getStreetListBydId",
//                            fetchType = FetchType.LAZY
//                    )
//            )}
//
//    )
//    DistrictAreaVo getDistrictAreaBydId(int dId);

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
