package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.domain.pojo.month.CityMonthPrice;
import edu.seu.housepricepredict.domain.pojo.month.DistrictMonthPrice;
import edu.seu.housepricepredict.domain.pojo.month.StreetMonthPrice;
import edu.seu.housepricepredict.mapper.area.CityMapper;
import edu.seu.housepricepredict.mapper.area.DistrictMapper;
import edu.seu.housepricepredict.mapper.area.StreetMapper;
import edu.seu.housepricepredict.mapper.month.CityMonthPriceMapper;
import edu.seu.housepricepredict.mapper.month.DistrictMonthPriceMapper;
import edu.seu.housepricepredict.mapper.month.StreetMonthPriceMapper;
import edu.seu.housepricepredict.service.ImportDataService;
import edu.seu.housepricepredict.utils.CsvReaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author guodonwu@163.com
 * @date 17:05 2019/3/5
 * 导入数据接口的实现类
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ImportDataServiceImpl implements ImportDataService {
    @Autowired
    CityMapper cityMapper;

    @Autowired
    DistrictMapper districtMapper;

    @Autowired
    StreetMapper streetMapper;

    @Autowired
    CityMonthPriceMapper cityMonthPriceMapper;

    @Autowired
    DistrictMonthPriceMapper districtMonthPriceMapper;

    @Autowired
    StreetMonthPriceMapper streetMonthPriceMapper;

    @Override
    public void insertCity() throws IOException {
        Set<String> set = CsvReaderUtil.readAreaName(0);
        for (String cName : set) {
            System.out.println(cName);
//            cityMapper.insertCity(cName);
        }
    }

    @Override
    public void insertDistrict() throws IOException {
        Set<String> set = CsvReaderUtil.readDistrict(cityMapper);
        for (String str : set) {
            String[] split = str.split(" ");
            int cId = Integer.parseInt(split[1]);
            System.out.println(str);
//            districtMapper.insertDistrict(split[0], cId);
        }
    }

    @Override
    public void insertStreet() throws IOException {
        Set<String> set = CsvReaderUtil.readStreet(cityMapper, districtMapper);
        for (String str : set) {
            String[] split = str.split(" ");
            int dId = Integer.parseInt(split[1]);
            System.out.println(str);
//            streetMapper.insertStreet(split[0], dId);
        }
    }

    @Override
    public void insertStreetMonthPrice() throws IOException {
        Set<String> set = CsvReaderUtil.readStreetMonthPrice(cityMapper, districtMapper, streetMapper);
        for (String str : set) {
            String[] split = str.split(" ");
            StreetMonthPrice smp = new StreetMonthPrice();
            smp.setsId(Integer.parseInt(split[0]));
            smp.setMonth(Integer.parseInt(split[1]));
            smp.setPrice(Integer.parseInt(split[2]));
            System.out.println(smp);
//            streetMonthPriceMapper.insertStreetMonthPrice(smp);
        }
    }

    @Override
    public void insertDistrictMonthPrice() {
        List<DistrictMonthPrice> list = districtMonthPriceMapper.getDistrictMonthPriceFromOthers();
        for (DistrictMonthPrice dmp : list) {
            System.out.println(dmp);
//            districtMonthPriceMapper.insertDistrictMonthPrice(dmp);
        }
    }

    @Override
    public void insertCityMonthPrice() {
        List<CityMonthPrice> list = cityMonthPriceMapper.getCityMonthPriceFromOthers();
        for (CityMonthPrice cmp : list) {
            System.out.println(cmp);
//            cityMonthPriceMapper.insertCityMonthPrice(cmp);
        }
    }

    @Override
    public void updateCityPrice() {
//        cityMapper.updateCityPrice(2);
    }

    @Override
    public void updateDistrictPrice() {
//        districtMapper.updateDistrictPrice(2);
    }

    @Override
    public void updateStreetPrice() {
//        streetMapper.updateStreetPrice(2);
    }
}
