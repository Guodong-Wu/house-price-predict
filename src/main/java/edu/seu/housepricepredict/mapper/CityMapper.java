package edu.seu.housepricepredict.mapper;

import edu.seu.housepricepredict.domain.pojo.area.City;
import edu.seu.housepricepredict.domain.vo.area.CityAreaVo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:01 2019/2/27
 * 城市的Mapper接口
 */

public interface CityMapper {

    /**
     * 根据城市名 查询城市信息
     */
    @Select("SELECT * FROM city WHERE c_name = #{name}")
    City getCityByName(String name);

    /**
     * 查询所有城市信息，除了某个id的城市
     */
    @Select("SELECT * FROM city WHERE c_id != #{id}")
    List<City> getCityListExceptId(int id);

    /**
     * 根据城市id 查询城市信息以及其下的行政区
     */
    @Select("SELECT * FROM city WHERE c_id = #{id}")
    @Results({
            @Result(id = true, column ="c_id", property = "cId"),
            @Result(column = "c_id", property = "districts", javaType = List.class,
                    many = @Many(
                            select = "edu.seu.housepricepredict.mapper.DistrictMapper.getDistrictsBycId",
                            fetchType = FetchType.LAZY
                    )
            )}

    )
    CityAreaVo getCityAreaById(int id);

}