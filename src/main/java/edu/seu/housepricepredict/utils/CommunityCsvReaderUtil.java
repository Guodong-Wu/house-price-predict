package edu.seu.housepricepredict.utils;

import com.csvreader.CsvReader;
import edu.seu.housepricepredict.domain.area.City;
import edu.seu.housepricepredict.domain.area.District;
import edu.seu.housepricepredict.domain.area.Street;
import edu.seu.housepricepredict.mapper.area.CityMapper;
import edu.seu.housepricepredict.mapper.area.DistrictMapper;
import edu.seu.housepricepredict.mapper.area.StreetMapper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author guodonwu@163.com
 * @date 9:17 2019/3/14
 * 读取csv文件工具类
 * 读取小区信息
 */

public class CommunityCsvReaderUtil {

    public static String fileName = "C:\\Users\\DELL\\Desktop\\项目实训\\数据\\江苏-去重-第二版\\江苏省总数据.csv";

    /**
     * 判断两个区域是否相等
     */
    private static boolean isEqual(String s1, String s2) {
        for (int i = 0; i < 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static Set<String> readCommunity
            (CityMapper cityMapper, DistrictMapper districtMapper, StreetMapper streetMapper) throws IOException {
        //结果集
        Set<String> set = new HashSet<>();
        CsvReader csvReader = new CsvReader(fileName, ',', Charset.forName("UTF-8"));

        //以下变量，为防止重复调用函数
        int cId = 0;
        int dId = 0;
        int sId = 0;

        String precName = "";
        String predName = "";
        String presName = "";

        //用于存放指定城市下的行政区集合
        List<District> districts = new ArrayList<>();
        //用于存放指定行政区下的街道集合
        List<Street> streets = new ArrayList<>();

        //判断城市在数据库中是否存在
        boolean cityIsExist = false;
        //判断行政区在数据库中是否存在
        boolean districtIsExist = false;
        //判断街道在数据库中是否存在
        boolean streetIsExist = false;

        while (csvReader.readRecord()) {
            //读取城市名, 数据库可能不存在该城市
            String cName = csvReader.get(0);
            if (!precName.equals(cName)) {
                //先假设该城市在数据库中找不到
                cityIsExist = false;
                //根据城市名查询城市
                City city = cityMapper.getCityBycName(cName);
                //如果城市在数据库中存在
                if (city != null) {
                    //城市存在标志设置为true
                    cityIsExist = true;
                    cId = city.getId();
                    //查询出该城市下所有行政区
                    districts = districtMapper.getDistrictListBycId(cId);
                }
                precName = cName;
            }

            //如果城市不存在，读取下一行
            if (!cityIsExist) {
                continue;
            }

            //读取行政区名，可能会发生冲突
            String dName = csvReader.get(1);
            //如果这一行与上一行的行政区名不相等
            if (!predName.equals(dName)) {
                //先假设该行政区在数据库中查不到
                districtIsExist = false;
                //遍历该城市下的行政区
                for (District d : districts) {
                    //在数据库中找到了行政区
                    if (isEqual(d.getName(), dName)) {
                        //将该行政区id赋值给dId
                        dId = d.getId();
                        //获取该行政区下的街道列表
                        streets = streetMapper.getStreetListBydId(dId);
                        //将行政区存在标志设置为true
                        districtIsExist = true;
                        break;
                    }
                }
                predName = dName;
            }

            //如果该行政区不存在，直接读下一行
            if (!districtIsExist) {
                continue;
            }

            //读取街道名
            String sName = csvReader.get(2);
            //如果这一行与上一行的街道名不相等
            if (!presName.equals(sName)) {
                //先假设该街道在数据库中查不到
                streetIsExist = false;
                //遍历该行政区下的街道
                for (Street s : streets) {
                    //在数据库中找到了街道
                    if (isEqual(s.getName(), sName)) {
                        //将该街道id赋值给sId
                        sId = s.getId();
                        //将街道存在标志设置为true
                        streetIsExist = true;
                        break;
                    }
                }
                presName = sName;
            }

            //如果该街道不存在，直接读下一行
            if (!streetIsExist) {
                continue;
            }

            //将小区名，房价和所在街道id封装成字符串，用空格分割
            String community = csvReader.get(3) + " " + csvReader.get(4) + " " + sId;
            set.add(community);
        }

        return set;
    }
}
