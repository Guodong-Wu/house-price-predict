package edu.seu.housepricepredict.domain.vo.area;

import edu.seu.housepricepredict.domain.pojo.area.City;
import edu.seu.housepricepredict.domain.pojo.area.District;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:53 2019/2/28
 */

public class CityAreaVo extends City {
    private List<District> districts;

    @Override
    public String toString() {
        return super.toString() + "CityAreaVo{" +
                "districts=" + districts +
                '}';
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
