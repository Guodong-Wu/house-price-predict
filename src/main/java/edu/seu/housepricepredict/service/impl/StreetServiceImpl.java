package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.domain.area.Street;
import edu.seu.housepricepredict.domain.month.StreetMonthPrice;
import edu.seu.housepricepredict.mapper.area.StreetMapper;
import edu.seu.housepricepredict.mapper.month.StreetMonthPriceMapper;
import edu.seu.housepricepredict.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:33 2019/2/27
 * 街道的Service实现类
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class StreetServiceImpl implements StreetService {

    @Autowired
    private StreetMapper streetMapper;

    @Autowired
    private StreetMonthPriceMapper streetMonthPriceMapper;

    @Override
    public List<Street> getStreetListBydId(int dId) {
        return streetMapper.getStreetListBydId(dId);
    }

    @Override
    public String getStreetNameById(int sId) {
        return streetMapper.getStreetNameById(sId);
    }

    @Override
    public List<StreetMonthPrice> getStreetMonthPriceBysId(int sId) {
        return streetMonthPriceMapper.getStreetMonthPriceBysId(sId);
    }
}
