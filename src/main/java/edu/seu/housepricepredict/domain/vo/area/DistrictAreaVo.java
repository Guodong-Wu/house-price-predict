package edu.seu.housepricepredict.domain.vo.area;

import edu.seu.housepricepredict.domain.pojo.area.District;
import edu.seu.housepricepredict.domain.pojo.area.Street;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 15:50 2019/2/28
 */

public class DistrictAreaVo extends District {
    private List<Street> streets;

    @Override
    public String toString() {
        return super.toString() + "DistrictAreaVo{" +
                "streets=" + streets +
                '}';
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }
}
