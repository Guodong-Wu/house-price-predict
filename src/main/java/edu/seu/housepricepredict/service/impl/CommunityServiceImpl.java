package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.domain.area.Community;
import edu.seu.housepricepredict.mapper.area.CommunityMapper;
import edu.seu.housepricepredict.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:39 2019/2/27
 * 小区的Service实现类
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public List<Community> getCommunityListBysId(int sId) {
        return communityMapper.getCommunityListBysId(sId);
    }
}
