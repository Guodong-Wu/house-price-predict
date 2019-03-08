package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.domain.vo.area.CityAreaVo;
import edu.seu.housepricepredict.mapper.area.CityMapper;
import edu.seu.housepricepredict.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author guodonwu@163.com
 * @date 10:30 2019/2/27
 * 城市的Service实现类
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;


    @Override
    public int getCityIdBycName(String cName) {
        return cityMapper.getCityIdBycName(cName);
    }

    @Override
    public CityAreaVo getCityAreaBycId(int cId) {
        return cityMapper.getCityAreaBycId(cId);
    }


}
