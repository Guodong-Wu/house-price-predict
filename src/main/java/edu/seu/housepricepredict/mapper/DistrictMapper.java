package edu.seu.housepricepredict.mapper;

import edu.seu.housepricepredict.domain.pojo.area.District;
import edu.seu.housepricepredict.domain.vo.area.DistrictAreaVo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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


}
