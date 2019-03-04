package edu.seu.housepricepredict.utils;

import com.csvreader.CsvReader;
import edu.seu.housepricepredict.mapper.CityMapper;
import edu.seu.housepricepredict.mapper.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

/**
 * @author guodonwu@163.com
 * @date 10:04 2019/3/4
 */

@Component
public class ReadAreaUtils {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private DistrictMapper districtMapper;

    private static String fileName = "C:\\Users\\DELL\\Desktop\\项目实训\\week1部分数据汇总\\江苏\\jiangsu_street.csv";

    /**
     * 读取城市名。区名，街道名
     * @return
     * @throws FileNotFoundException
     */
    public static Set<String> readAreaName(int column) throws IOException {
        Set<String> set = new HashSet<>();
        CsvReader csvReader = new CsvReader(fileName, ',', Charset.forName("UTF-8"));

        while (csvReader.readRecord()) {
            String name = csvReader.get(column);
            set.add(name);
        }
        return set;
    }

    /**
     * 读取行政区名，并关联城市
     * @return
     * @throws IOException
     */
    public Set<String> readDistrict() throws IOException {
        Set<String> set = new HashSet<>();
        CsvReader csvReader = new CsvReader(fileName, ',', Charset.forName("UTF-8"));

        String precName = "";
        String predName = "";
        int cId = 0;
        while (csvReader.readRecord()) {
            String cName = csvReader.get(0);
            if (!precName.equals(cName)) {
                cId = cityMapper.getCityIdByName(cName);
                precName = cName;
            }
            String dName = csvReader.get(1);
            if (predName.equals(dName)) {
                continue;
            }
            set.add(dName + " "+ cId);
            predName = dName;
        }
        return set;
    }

    /**
     * 读取街道，并关联行政区
     */
    public Set<String> readStreet() throws IOException {
        Set<String> set = new HashSet<>();
        CsvReader csvReader = new CsvReader(fileName, ',', Charset.forName("UTF-8"));

        String precName = "";
        String predName = "";
        String presName = "";
        int cId = 0;
        int dId = 0;
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
            if (sName.equals(presName)) {
                continue;
            }
            set.add(sName + " " + dId);
            presName = sName;
        }
        return set;
    }

}
