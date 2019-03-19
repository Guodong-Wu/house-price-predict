package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.domain.month.CityMonthPrice;
import edu.seu.housepricepredict.domain.month.DistrictMonthPrice;
import edu.seu.housepricepredict.domain.month.StreetMonthPrice;
import edu.seu.housepricepredict.mapper.area.CityMapper;
import edu.seu.housepricepredict.mapper.area.CommunityMapper;
import edu.seu.housepricepredict.mapper.area.DistrictMapper;
import edu.seu.housepricepredict.mapper.area.StreetMapper;
import edu.seu.housepricepredict.mapper.month.CityMonthPriceMapper;
import edu.seu.housepricepredict.mapper.month.DistrictMonthPriceMapper;
import edu.seu.housepricepredict.mapper.month.StreetMonthPriceMapper;
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
        HistoryCsvReaderUtil.fileName = fileName;
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
            System.out.println(smp);
//            streetMonthPriceMapper.insertStreetMonthPrice(smp);
        }
    }

    @Override
    public void insertDistrictMonthPrice(String fileName) {
        HistoryCsvReaderUtil.fileName = fileName;
        List<DistrictMonthPrice> list = districtMonthPriceMapper.getDistrictMonthPriceFromOthers();
        for (DistrictMonthPrice dmp : list) {
            System.out.println(dmp);
//            districtMonthPriceMapper.insertDistrictMonthPrice(dmp);
        }
    }

    @Override
    public void insertCityMonthPrice(String fileName) {
        HistoryCsvReaderUtil.fileName = fileName;
        List<CityMonthPrice> list = cityMonthPriceMapper.getCityMonthPriceFromOthers();
        for (CityMonthPrice cmp : list) {
            System.out.println(cmp);
//            cityMonthPriceMapper.insertCityMonthPrice(cmp);
        }
    }

    @Override
    public void updateCityPrice(String fileName) {
        HistoryCsvReaderUtil.fileName = fileName;
//        cityMapper.updateCityPrice(2);
    }

    @Override
    public void updateDistrictPrice(String fileName) {
        HistoryCsvReaderUtil.fileName = fileName;
//        districtMapper.updateDistrictPrice(2);
    }

    @Override
    public void updateStreetPrice(String fileName) {
        HistoryCsvReaderUtil.fileName = fileName;
//        streetMapper.updateStreetPrice(2);
    }
}
