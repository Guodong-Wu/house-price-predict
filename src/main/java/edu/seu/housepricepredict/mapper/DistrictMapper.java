package edu.seu.housepricepredict.mapper;

import edu.seu.housepricepredict.domain.pojo.area.District;
import edu.seu.housepricepredict.domain.vo.area.DistrictAreaVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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
    @Select("Select d_id, d_name, d_price FROM district WHERE c_id = #{id}")
    List<District> getDistrictsBycId(int id);

    /**
     * 根据行政区id 查询行政区信息以及其下的街道
     */
    @Select("Select d_id, d_name, d_price FROM district WHERE d_id = #{id}")
    @Results({
            @Result(id = true, column ="d_id", property = "dId"),
            @Result(column = "d_id", property = "streets", javaType = List.class,
                    many = @Many(
                            select = "edu.seu.housepricepredict.mapper.StreetMapper.getStreetsBydId",
                            fetchType = FetchType.LAZY
                    )
            )}

    )
    DistrictAreaVo getDistrictAreaById(int id);

    /**
     * 插入行政区信息
     */
    @Options(useGeneratedKeys = true, keyColumn = "d_id", keyProperty = "dId")
    @Insert("INSERT INTO district(d_name, c_id) VALUES(#{dName}, #{cId})")
    int insertDistrict(@Param("dName")String dName, @Param("cId")int cId);

    /**
     * 根据行政区名和城市id，查询行政区id
     */
    @Select("SELECT d_id FROM district WHERE d_name = #{dName} AND c_id = #{cId}")
    int getdIdbydNameAndcId(@Param("dName")String dName, @Param("cId")int cId);

}
