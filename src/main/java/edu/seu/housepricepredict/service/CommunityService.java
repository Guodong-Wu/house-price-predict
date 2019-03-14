package edu.seu.housepricepredict.service;

import edu.seu.housepricepredict.domain.area.Community;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:30 2019/2/27
 * 小区的Service接口
 */

public interface CommunityService {

    List<Community> getCommunityListBysId(int sId);
}
