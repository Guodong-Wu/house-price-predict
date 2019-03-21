package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.domain.month.CityMonthPrice;
import edu.seu.housepricepredict.domain.year.CityYearPrice;
import edu.seu.housepricepredict.mapper.area.CityMapper;
import edu.seu.housepricepredict.mapper.month.CityMonthPriceMapper;
import edu.seu.housepricepredict.mapper.year.CityYearPriceMapper;
import edu.seu.housepricepredict.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Autowired
    private CityMonthPriceMapper cityMonthPriceMapper;

    @Autowired
    private CityYearPriceMapper cityYearPriceMapper;


    @Override
    public int getCityIdBycName(String cName) {
        return cityMapper.getCityIdBycName(cName);
    }

    @Override
    public List<CityMonthPrice> getCityMonthPriceBycId(int cId) {
        return cityMonthPriceMapper.getCityMonthPriceBycId(cId);
    }

    @Override
    public String getCityNameBycId(int cId) {
        return cityMapper.getCityNameBycId(cId);
    }

    @Override
    public List<CityYearPrice> getCityYearPriceBycId(int cId) {
        return cityYearPriceMapper.getCityYearPriceBycId(cId);
    }

    //    @Override
//    public CityAreaVo getCityAreaBycId(int cId) {
//        return cityMapper.getCityAreaBycId(cId);
//    }

}
