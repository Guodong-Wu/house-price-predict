package edu.seu.housepricepredict.utils;

import com.csvreader.CsvReader;
import edu.seu.housepricepredict.mapper.CityMapper;
import edu.seu.housepricepredict.mapper.DistrictMapper;
import edu.seu.housepricepredict.mapper.StreetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

/**
 * @author guodonwu@163.com
 * @date 15:50 2019/3/4
 */

@Component
public class ReadMonthPriceUtils {

    static String fileName = "C:\\Users\\DELL\\Desktop\\项目实训\\week1部分数据汇总\\江苏\\jiangsu_street.csv";

    @Autowired
    CityMapper cityMapper;

    @Autowired
    DistrictMapper districtMapper;

    @Autowired
    StreetMapper streetMapper;

    public Set<String> readStreetMonthPrice() throws IOException {
        Set<String> set = new HashSet<>();
        CsvReader csvReader = new CsvReader(fileName, ',', Charset.forName("UTF-8"));

        int cId = 0;
        int dId = 0;
        int sId = 0;
        String precName = "";
        String predName = "";
        String presName = "";
        while (csvReader.readRecord()) {
            String cName = csvReader.get(0);
            if (!precName.equals(cName)) {
                cId = cityMapper.getCityIdByName(cName);
                precName = cName;
            }
            String dName = csvReader.get(1);
            if (!predName.equals(dName)) {
                dId = districtMapper.getdIdbydNameAndcId(dName, cId);
                predName = dName;
            }
            String sName = csvReader.get(2);
            if (!sName.equals(presName)) {
                sId = streetMapper.getsIdBysNameAnddId(sName, dId);
                presName = sName;
            }
            String date = csvReader.get(3);
            String[] split = date.split("/");
            if (split[0].equals("2018") && (split[1].equals("1") || split[1].equals("2"))) {
                continue;
            }
            set.add(sId + " " + split[1] + " " + csvReader.get(4));
        }
        return set;
    }
}
