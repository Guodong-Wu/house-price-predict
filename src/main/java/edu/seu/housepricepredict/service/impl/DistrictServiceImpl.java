package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.domain.area.District;
import edu.seu.housepricepredict.domain.month.DistrictMonthPrice;
import edu.seu.housepricepredict.domain.year.DistrictYearPrice;
import edu.seu.housepricepredict.mapper.area.DistrictMapper;
import edu.seu.housepricepredict.mapper.month.DistrictMonthPriceMapper;
import edu.seu.housepricepredict.mapper.year.DistrictYearPriceMapper;
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

    @Autowired
    private DistrictMonthPriceMapper districtMonthPriceMapper;

    @Autowired
    private DistrictYearPriceMapper districtYearPriceMapper;

    @Override
    public List<District> getDistrictListBycId(int cId) {
        return districtMapper.getDistrictListBycId(cId);
    }

    @Override
    public String getDistrictNameById(int dId) {
        return districtMapper.getDistrictNameById(dId);
    }

    @Override
    public List<DistrictMonthPrice> getDistrictMonthPriceBydId(int dId) {
        return districtMonthPriceMapper.getDistrictMonthPriceBydId(dId);
    }

    @Override
    public List<DistrictYearPrice> getDistrictYearPriceBydId(int dId) {
        return districtYearPriceMapper.getDistrictYearPriceBydId(dId);
    }

}
