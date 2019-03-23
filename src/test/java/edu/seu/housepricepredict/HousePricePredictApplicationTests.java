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


//    @Test
//    public void test() throws IOException {
//        String directoryName = "C:\\Users\\DELL\\Desktop\\项目实训\\数据\\汇总\\全国历史数据";
//        File file = new File(directoryName);
//        List<String> list = new ArrayList<>();
//        File[] provinces = file.listFiles();
//        for (int i = 0; i < provinces.length; i++) {
//            File[] data = provinces[i].listFiles();
//            for (int j = 0; j < data.length; j++) {
//                if (data[j].getName().matches(".*street.*")) {
//                    String fileName = directoryName + "\\" +provinces[i].getName() + "\\" + data[j].getName();
//                    list.add(fileName);
//                }
//            }
//        }
//
//        for (String fileName : list) {
//            importDataService.insertStreetYearPrice(fileName);
//        }
//    }

//    @Test
//    public void insert() throws IOException {
//        String directoryName = "C:\\Users\\DELL\\Desktop\\项目实训\\数据\\汇总\\全国房价";
//        File file = new File(directoryName);
//        List<String> list = new ArrayList<>();
//        File[] provinces = file.listFiles();
//        for (int i = 0; i < provinces.length; i++) {
//            File[] data = provinces[i].listFiles();
//            for (int j = 0; j < data.length; j++) {
//                String fileName = directoryName + "\\" +provinces[i].getName() + "\\" + data[j].getName();
//                list.add(fileName);
//            }
//        }
//
//        for (String fileName : list) {
//            importDataService.insertCommunity(fileName);
//        }
//    }

//    @Test
//    public void test01() throws IOException {
//        String fileName = "C:\\Users\\DELL\\Desktop\\项目实训\\数据\\汇总\\全国历史数据\\江苏\\jiangsu_street.csv";
//        importDataService.insertStreetYearPrice(fileName);
//    }

//    @Test
//    public void test() throws IOException {
//        String fileName = "C:\\Users\\DELL\\Desktop\\项目实训\\数据\\汇总\\house_predict.csv";
//        importDataService.insertCityPredictPrice();
//    }


}
