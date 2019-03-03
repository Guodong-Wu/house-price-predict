package edu.seu.housepricepredict.mapper;

import edu.seu.housepricepredict.domain.pojo.area.Street;
import edu.seu.housepricepredict.domain.vo.area.StreetAreaVo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

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
    @Select("SELECT s_id, s_name, s_price FROM street WHERE d_id = #{id}")
    List<Street> getStreetsBydId(int id);

    /**
     * 根据街道id，查找街道信息以及其下的小区
     */
    @Select("Select s_id, s_name, s_price FROM street WHERE s_id = #{id}")
    @Results({
            @Result(id = true, column ="s_id", property = "sId"),
            @Result(column = "s_id", property = "communities", javaType = List.class,
                    many = @Many(
                            select = "edu.seu.housepricepredict.mapper.CommunityMapper.getCommunityBysId",
                            fetchType = FetchType.LAZY
                    )
            )}

    )
    StreetAreaVo getStreetAreaById(int id);
}
