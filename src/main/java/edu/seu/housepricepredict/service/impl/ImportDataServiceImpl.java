package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.domain.month.CityMonthPrice;
import edu.seu.housepricepredict.domain.month.DistrictMonthPrice;
import edu.seu.housepricepredict.domain.month.StreetMonthPrice;
import edu.seu.housepricepredict.domain.year.CityYearPrice;
import edu.seu.housepricepredict.domain.year.DistrictYearPrice;
import edu.seu.housepricepredict.domain.year.StreetYearPrice;
import edu.seu.housepricepredict.mapper.area.CityMapper;
import edu.seu.housepricepredict.mapper.area.CommunityMapper;
import edu.seu.housepricepredict.mapper.area.DistrictMapper;
import edu.seu.housepricepredict.mapper.area.StreetMapper;
import edu.seu.housepricepredict.mapper.month.CityMonthPriceMapper;
import edu.seu.housepricepredict.mapper.month.DistrictMonthPriceMapper;
import edu.seu.housepricepredict.mapper.month.StreetMonthPriceMapper;
import edu.seu.housepricepredict.mapper.year.CityYearPriceMapper;
import edu.seu.housepricepredict.mapper.year.DistrictYearPriceMapper;
import edu.seu.housepricepredict.mapper.year.StreetYearPriceMapper;
import edu.seu.housepricepredict.service.ImportDataService;
import edu.seu.housepricepredict.utils.CommunityCsvReaderUtil;
import edu.seu.housepricepredict.utils.HistoryCsvReaderUtil;
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
    private CityMapper cityMapper;

    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private StreetMapper streetMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private CityMonthPriceMapper cityMonthPriceMapper;

    @Autowired
    private DistrictMonthPriceMapper districtMonthPriceMapper;

    @Autowired
    private StreetMonthPriceMapper streetMonthPriceMapper;

    @Autowired
    private StreetYearPriceMapper streetYearPriceMapper;

    @Autowired
    private DistrictYearPriceMapper districtYearPriceMapper;

    @Autowired
    private CityYearPriceMapper cityYearPriceMapper;

    @Override
    public void insertCity(String fileName) throws IOException {
        HistoryCsvReaderUtil.fileName = fileName;
        Set<String> set = HistoryCsvReaderUtil.readAreaName(0);
        for (String cName : set) {
            cityMapper.insertCity(cName);
        }
    }

    @Override
    public void insertDistrict(String fileName) throws IOException {
        HistoryCsvReaderUtil.fileName = fileName;
        Set<String> set = HistoryCsvReaderUtil.readDistrict(cityMapper);
        for (String str : set) {
            String[] split = str.split(" ");
            int cId = Integer.parseInt(split[1]);
            districtMapper.insertDistrict(split[0], cId);
        }
    }

    @Override
    public void insertStreet(String fileName) throws IOException {
        HistoryCsvReaderUtil.fileName = fileName;
        Set<String> set = HistoryCsvReaderUtil.readStreet(cityMapper, districtMapper);
        for (String str : set) {
            String[] split = str.split(" ");
            int dId = Integer.parseInt(split[1]);
            streetMapper.insertStreet(split[0], dId);
        }
    }

    @Override
    public void insertCommunity(String fileName) throws IOException {
        CommunityCsvReaderUtil.fileName = fileName;
        Set<String> set = CommunityCsvReaderUtil.readCommunity(cityMapper, districtMapper, streetMapper);
        for (String str : set) {
            String[] split = str.split(" ");
            String coName = split[0];
            int price = Integer.parseInt(split[1]);
            int sId = Integer.parseInt(split[2]);
            communityMapper.insertCommunity(coName, price, sId);
        }
    }

    @Override
    public void insertStreetMonthPrice(String fileName) throws IOException {
        HistoryCsvReaderUtil.fileName = fileName;
        Set<String> set = HistoryCsvReaderUtil.readStreetMonthPrice(cityMapper, districtMapper, streetMapper);
        for (String str : set) {
            String[] split = str.split(" ");
            StreetMonthPrice smp = new StreetMonthPrice();
            smp.setsId(Integer.parseInt(split[0]));
            smp.setMonth(Integer.parseInt(split[1]));
            smp.setPrice(Integer.parseInt(split[2]));
            streetMonthPriceMapper.insertStreetMonthPrice(smp);
        }
    }

    @Override
    public void insertDistrictMonthPrice() {
        List<DistrictMonthPrice> list = districtMonthPriceMapper.getDistrictMonthPriceFromOthers();
        for (DistrictMonthPrice dmp : list) {
//            districtMonthPriceMapper.insertDistrictMonthPrice(dmp);
        }
    }

    @Override
    public void insertCityMonthPrice() {
        List<CityMonthPrice> list = cityMonthPriceMapper.getCityMonthPriceFromOthers();
        for (CityMonthPrice cmp : list) {
//            cityMonthPriceMapper.insertCityMonthPrice(cmp);
        }
    }

    @Override
    public void updateCityPrice() {
        cityMapper.updateCityPrice(3);
    }

    @Override
    public void updateDistrictPrice() {
        districtMapper.updateDistrictPrice(3);
    }

    @Override
    public void updateStreetPrice() {
        streetMapper.updateStreetPrice(3);
    }

    @Override
    public void insertStreetYearPrice(String fileName) throws IOException {
        HistoryCsvReaderUtil.fileName = fileName;
        Set<String> set = HistoryCsvReaderUtil.readStreetYearPrice(cityMapper, districtMapper, streetMapper);
        for (String str : set) {
            String[] split = str.split(" ");
            StreetYearPrice syp = new StreetYearPrice();
            syp.setsId(Integer.parseInt(split[0]));
            syp.setYear(Integer.parseInt(split[1]));
            syp.setPrice(Integer.parseInt(split[2]));
            streetYearPriceMapper.insertStreetYearPrice(syp);
        }
    }

    @Override
    public void insertDistrictYearPrice() {
        List<DistrictYearPrice> list = districtYearPriceMapper.getDistrictYearPriceFromOthers();
        for (DistrictYearPrice dyp : list) {
            districtYearPriceMapper.insertDistrictYearPrice(dyp);
        }
    }

    @Override
    public void insertCityYearPrice() {
        List<CityYearPrice> list = cityYearPriceMapper.getCityYearPriceFromOthers();
        for (CityYearPrice cyp : list) {
            cityYearPriceMapper.insertCityYearPrice(cyp);
        }
    }
}
