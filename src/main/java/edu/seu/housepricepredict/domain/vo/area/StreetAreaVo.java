package edu.seu.housepricepredict.domain.vo.area;

import edu.seu.housepricepredict.domain.pojo.area.Community;
import edu.seu.housepricepredict.domain.pojo.area.Street;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 11:00 2019/3/3
 */

public class StreetAreaVo extends Street {
    private List<Community> communities;

    @Override
    public String toString() {
        return super.toString() + "StreetAreaVo{" +
                "communities=" + communities +
                '}';
    }

    public List<Community> getCommunities() {
        return communities;
    }

    public void setCommunities(List<Community> communities) {
        this.communities = communities;
    }
}
