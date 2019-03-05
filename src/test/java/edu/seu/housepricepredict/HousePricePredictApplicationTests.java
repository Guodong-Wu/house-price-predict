package edu.seu.housepricepredict;

import edu.seu.housepricepredict.service.ImportDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HousePricePredictApplicationTests {

    @Autowired
    ImportDataService importDataService;

    @Test
    public void testCityMapper() {

    }

    @Test
    public void testDistrictMapper() {

    }

    @Test
    public void testStreetMapper() {

    }

    @Test
    public void insertCity() throws IOException {

    }

    @Test
    public void insertDistrict() throws IOException {

    }

    @Test
    public void insertStreet() throws IOException {

    }

    @Test
    public void insertStreetMonthPrice() throws IOException {
        importDataService.insertStreetMonthPrice();
    }

    @Test
    public void insertDistrictMonthPrice() {

    }

    @Test
    public void insertCityMonthPrice() {

    }

    @Test
    public void updateCityPrice() {

    }

    @Test
    public void updateDistrictPrice() {

    }

    @Test
    public void updateStreetPrice() {

    }


}
