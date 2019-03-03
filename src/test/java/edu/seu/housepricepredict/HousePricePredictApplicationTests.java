package edu.seu.housepricepredict;

import edu.seu.housepricepredict.domain.pojo.area.City;
import edu.seu.housepricepredict.domain.vo.area.CityAreaVo;
import edu.seu.housepricepredict.domain.vo.area.DistrictAreaVo;
import edu.seu.housepricepredict.domain.vo.area.StreetAreaVo;
import edu.seu.housepricepredict.mapper.CityMapper;
import edu.seu.housepricepredict.mapper.CommunityMapper;
import edu.seu.housepricepredict.mapper.DistrictMapper;
import edu.seu.housepricepredict.mapper.StreetMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Test
    public void testCityMapper() {

        CityAreaVo cityAreaVo = cityMapper.getCityAreaById(1);
        City city = cityMapper.getCityByName("苏州");
        List<City> cityList = cityMapper.getCityListExceptId(1);
        System.out.println(cityAreaVo);
        System.out.println(city);
        System.out.println(cityList);

    }

    @Test
    public void testDistrictMapper() {
        DistrictAreaVo districtAreaVo = districtMapper.getDistrictAreaById(2);
        System.out.println(districtAreaVo);
    }

    @Test
    public void testStreetMapper() {
        StreetAreaVo streetAreaVo = streetMapper.getStreetAreaById(1);
        System.out.println(streetAreaVo);
    }

    @Test
    public void testCommunityMapper() {

    }

}
