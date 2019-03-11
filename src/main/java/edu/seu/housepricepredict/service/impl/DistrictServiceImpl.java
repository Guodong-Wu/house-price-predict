package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.domain.pojo.area.District;
import edu.seu.housepricepredict.mapper.area.DistrictMapper;
import edu.seu.housepricepredict.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:32 2019/2/27
 * 行政区的Service实现类
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getDistrictListBycId(int cId) {
        return districtMapper.getDistrictListBycId(cId);
    }
}
