package edu.seu.housepricepredict.mapper;

import edu.seu.housepricepredict.domain.pojo.area.Street;
import org.apache.ibatis.annotations.Select;

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
}
