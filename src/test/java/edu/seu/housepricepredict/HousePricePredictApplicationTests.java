package edu.seu.housepricepredict;

import edu.seu.housepricepredict.domain.vo.area.CityAreaVo;
import edu.seu.housepricepredict.domain.vo.area.DistrictAreaVo;
import edu.seu.housepricepredict.domain.vo.area.StreetAreaVo;
import edu.seu.housepricepredict.mapper.CityMapper;
import edu.seu.housepricepredict.mapper.CommunityMapper;
import edu.seu.housepricepredict.mapper.DistrictMapper;
import edu.seu.housepricepredict.mapper.StreetMapper;
import edu.seu.housepricepredict.utils.ReadAreaUtils;
import edu.seu.housepricepredict.utils.ReadMonthPriceUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HousePricePredictApplicationTests {

    @Autowired
    CityMapper cityMapper;

    @Autowired
    DistrictMapper districtMapper;

    @Autowired
    StreetMapper streetMapper;

    @Autowired
    CommunityMapper communityMapper;

    @Autowired
    ReadAreaUtils readAreaUtils;

    @Autowired
    ReadMonthPriceUtils readMonthPriceUtils;

    @Test
    public void testCityMapper() {

        CityAreaVo cityAreaVo = cityMapper.getCityAreaById(5);
        System.out.println(cityAreaVo);
//        City city = cityMapper.getCityByName("苏州");
//        List<City> cityList = cityMapper.getCityListExceptId(1);
//        System.out.println(cityAreaVo);
//        System.out.println(city);
//        System.out.println(cityList);

    }

    @Test
    public void testDistrictMapper() {
        DistrictAreaVo districtAreaVo = districtMapper.getDistrictAreaById(92);
        System.out.println(districtAreaVo);
    }

    @Test
    public void testStreetMapper() {
        StreetAreaVo streetAreaVo = streetMapper.getStreetAreaById(1);
        System.out.println(streetAreaVo);
    }

    @Test
    public void insertCity() throws IOException {
        Set<String> set = ReadAreaUtils.readAreaName(0);
        for (String cName : set) {
            cityMapper.insertCity(cName);
        }
    }

    @Test
    public void insertDistrict() throws IOException {
        Set<String> set = readAreaUtils.readDistrict();
        for (String str : set) {
            String[] split = str.split(" ");
            int cId = Integer.parseInt(split[1]);
            districtMapper.insertDistrict(split[0], cId);
        }
    }

    @Test
    public void insertStreet() throws IOException {
        Set<String> set = readAreaUtils.readStreet();
        for (String str : set) {
            String[] split = str.split(" ");
            int dId = Integer.parseInt(split[1]);
            streetMapper.insertStreet(split[0], dId);
        }
    }

//    @Test
//    public void insertStreetMonthPrice() throws IOException {
//        Set<String> set = readMonthPriceUtils.readStreetMonthPrice();
//        for (String str : set) {
//            String[] split = str.split(" ");
//            int sId = Integer.parseInt(split[0]);
//            int month = Integer.parseInt(split[1]);
//            int price = Integer.parseInt(split[2]);
//            streetMapper.insertStreetMonthPrice(sId, month, price);
//        }
//    }


}
