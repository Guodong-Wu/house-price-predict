package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.mapper.DistrictMapper;
import edu.seu.housepricepredict.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guodonwu@163.com
 * @date 10:32 2019/2/27
 * 行政区的Service实现类
 */
@Transactional(rollbackFor = Exception.class)
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictMapper districtMapper;
}
