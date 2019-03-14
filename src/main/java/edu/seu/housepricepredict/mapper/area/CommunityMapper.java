package edu.seu.housepricepredict.mapper.area;

import edu.seu.housepricepredict.domain.area.Community;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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
    @Select("SELECT id, name, price FROM community WHERE s_id = #{sId}")
    List<Community> getCommunityListBysId(int sId);


    /**
     * 插入街道信息
     */
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Insert("INSERT INTO community(name, price, s_id) VALUES(#{coName}, #{price}, #{sId})")
    int insertCommunity(@Param("coName")String coName, @Param("price")int price, @Param("sId")int sId);
}
