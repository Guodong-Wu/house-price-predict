package edu.seu.housepricepredict;


import edu.seu.housepricepredict.service.CityService;
import edu.seu.housepricepredict.service.ImportDataService;
import edu.seu.housepricepredict.utils.HistoryCsvReaderUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HousePricePredictApplicationTests {

    @Autowired
    ImportDataService importDataService;

    @Autowired
    CityService cityService;

    @Test
    public void test() {

    }


}
