package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.mapper.CommunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guodonwu@163.com
 * @date 10:39 2019/2/27
 * 小区的Service实现类
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class CommunityServiceImpl {

    @Autowired
    private CommunityMapper communityMapper;
}
