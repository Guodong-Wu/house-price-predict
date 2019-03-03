package edu.seu.housepricepredict.mapper;

import edu.seu.housepricepredict.domain.pojo.area.Community;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:12 2019/2/27
 * 小区的Mapper接口
 */

public interface CommunityMapper {

    /**
     * 根据街道id，查询小区列表
     */
    @Select("SELECT co_id, co_name, co_price FROM community WHERE s_id = #{id}")
    List<Community> getCommunityBysId(int id);

}
