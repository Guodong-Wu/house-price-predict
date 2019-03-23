package edu.seu.housepricepredict.utils;

import com.csvreader.CsvReader;
import edu.seu.housepricepredict.mapper.area.CityMapper;
import edu.seu.housepricepredict.mapper.area.DistrictMapper;
import edu.seu.housepricepredict.mapper.area.StreetMapper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

/**
 * @author guodonwu@163.com
 * @date 10:04 2019/3/4
 * 读取csv文件的工具类、
 * 读取历史数据
 */

public class HistoryCsvReaderUtil {

    public static String fileName = "C:\\Users\\DELL\\Desktop\\项目实训\\week1部分数据汇总\\江苏\\jiangsu_street.csv";

    /**
     * 读取城市名、区名或街道名
     * 选择要读取的column值
     */
    public static Set<String> readAreaName(int column) throws IOException {
        //存放名称的set集合
        Set<String> set = new HashSet<>();
        //创建csv读取器
        CsvReader csvReader = new CsvReader(fileName, ',', Charset.forName("UTF-8"));

        //一行一行读，直到读到最后一行，跳出循环
        while (csvReader.readRecord()) {
            //读取某一列
            String name = csvReader.get(column);
            //加入集合，会自动过滤重复值
            set.add(name);
        }
        return set;
    }

    /**
     * 读取行政区名，并关联城市cid
     */
    public static Set<String> readDistrict(CityMapper cityMapper) throws IOException {
        //存放名称的set集合
        Set<String> set = new HashSet<>();
        //创建csv读取器
        CsvReader csvReader = new CsvReader(fileName, ',', Charset.forName("UTF-8"));

        //用于存放前一个城市的名字，避免重复调用函数
        String precName = "";
        //用于存放前一个行政区的名字，避免加入相同的数据
        String predName = "";
        //存放当前行政区的城市id
        int cId = 0;
        //一行一行读
        while (csvReader.readRecord()) {
            //获取城市名
            String cName = csvReader.get(0);
            //如果城市名和前面的城市名不同
            if (!precName.equals(cName)) {
                //根据城市名，获取新的cid
                cId = cityMapper.getCityIdBycName(cName);
                //赋予新值
                precName = cName;
            }
            //获取行政区名
            String dName = csvReader.get(1);
            //如果行政区名和之前的行政区名相同，读取下一行数据
            if (predName.equals(dName)) {
                continue;
            }
            //将行政区名和城市id放到集合中，用空格分割
            set.add(dName + " "+ cId);
            //赋予新值
            predName = dName;
        }
        return set;
    }

    /**
     * 读取街道，并关联行政区
     */
    public static Set<String> readStreet(CityMapper cityMapper, DistrictMapper districtMapper) throws IOException {
        Set<String> set = new HashSet<>();
        CsvReader csvReader = new CsvReader(fileName, ',', Charset.forName("UTF-8"));

        //存放前一个城市名，避免重复调用函数
        String precName = "";
        //存放前一个行政区名，避免重读调用函数
        String predName = "";
        //存放前一个街道名，避免存入相同数据
        String presName = "";
        //当前城市id
        int cId = 0;
        //当前行政区id
        int dId = 0;
        while (csvReader.readRecord()) {
            //获取城市名
            String cName = csvReader.get(0);
            if (!precName.equals(cName)) {
                //根据城市名，获取新的cid
                cId = cityMapper.getCityIdBycName(cName);
                precName = cName;
            }
            //获取行政区名
            String dName = csvReader.get(1);
            if (!predName.equals(dName)) {
                //根据行政区名和城市id，获取行政区的id
                dId = districtMapper.getdIdBydNameAndcId(dName, cId);
                predName = dName;
            }
            //获取街道名
            String sName = csvReader.get(2);
            if (sName.equals(presName)) {
                continue;
            }
            //将街道名和行政区id放到集合中，用空格分割
            set.add(sName + " " + dId);
            presName = sName;
        }
        return set;
    }

    /**
     * 读取所有街道每月房价
     */
    public static Set<String> readStreetMonthPrice
            (CityMapper cityMapper, DistrictMapper districtMapper, StreetMapper streetMapper) throws IOException {
        //结果集
        Set<String> set = new HashSet<>();
        CsvReader csvReader = new CsvReader(fileName, ',', Charset.forName("UTF-8"));

        //以下变量，为防止重复调用函数
        int cId = 0;
        Integer dId = 0;
        Integer sId = 0;
        String precName = "";
        String predName = "";
        String presName = "";

        while (csvReader.readRecord()) {
            //读取城市名
            String cName = csvReader.get(0);
            if (!precName.equals(cName)) {
                //根据城市名查询cid
                cId = cityMapper.getCityIdBycName(cName);
                precName = cName;
            }
            //读取行政区名
            String dName = csvReader.get(1);
            if (!predName.equals(dName)) {
                //根据行政区名和城市id，查询行did
                dId = districtMapper.getdIdBydNameAndcId(dName, cId);
                predName = dName;
            }
            //若行政区不存在
            if (dId == null) {
                System.out.println(cName + "," + dName);
                continue;
            }
            //读取街道名
            String sName = csvReader.get(2);
            if (!sName.equals(presName)) {
                //根据街道名和行政区id，查询sid
                sId = streetMapper.getsIdBysNameAnddId(sName, dId);
                presName = sName;
            }
            //若街道不存在
            if (sId == null) {
                System.out.println(cName + "," + dName + "," + sName);
                continue;
            }
            //获取日期
            String date = csvReader.get(3);
            String[] split = date.split("/");
            //如果房价日期为2018或2019
//            if (split[0].equals("2018") || split[0].equals("2019")) {
//                //去掉2018年1月、2月和3月的数据
//                if (split[0].equals("2018") &&
//                        (split[1].equals("1") || split[1].equals("2") || split[1].equals("3"))) {
//                    continue;
//                }
//                //将街道id，月份，房价加入到结果集中，用空格分割
//                set.add(sId + " " + split[1] + " " + csvReader.get(4));
//            }
            int price = (int) Double.parseDouble(csvReader.get(4));
            set.add(sId + " " + split[1] + " " + price);
        }
        return set;
    }

    public static Set<String> readStreetYearPrice
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
        String preYear = "";

        int count = 0;
        int sum = 0;

        while (csvReader.readRecord()) {
            //读取城市名
            String cName = csvReader.get(0);
            if (!precName.equals(cName)) {
                //根据城市名查询cid
                cId = cityMapper.getCityIdBycName(cName);
                precName = cName;
            }
            //读取行政区名
            String dName = csvReader.get(1);
            if (!predName.equals(dName)) {
                //根据行政区名和城市id，查询行did
                dId = districtMapper.getdIdBydNameAndcId(dName, cId);
                predName = dName;
            }
            //读取街道名
            String sName = csvReader.get(2);
            //获取日期
            String date = csvReader.get(3);
            String[] split = date.split("/");

            //如果街道发生了改变，或者年份发生了改变
            if (!sName.equals(presName) || !preYear.equals(split[0])) {
                //如果是第一行的话
                if (presName.equals("")) {
                    //根据街道名和行政区id，查询sid
                    sId = streetMapper.getsIdBysNameAnddId(sName, dId);
                    presName = sName;
                    preYear = split[0];
                } else {
                    //将街道id，年份，年均价存到set里
                    set.add(sId + " " + preYear + " " + sum/count);

                    //如果街道没有发生变化，而是年份发生了变化
                    if (presName.equals(sName) && !preYear.equals(split[0])) {
                        preYear = split[0];
                    //如果街道发生了变化，而年份没有发生变化
                    } else if (!presName.equals(sName) && presName.equals(split[0])) {
                        sId = streetMapper.getsIdBysNameAnddId(sName, dId);
                        //更新街道名
                        presName = sName;
                    //如果街道名和年份名都发生了变化
                    } else {
                        //更新街道id
                        sId = streetMapper.getsIdBysNameAnddId(sName, dId);
                        //更新街道名
                        presName = sName;
                        //更新年份
                        preYear = split[0];
                    }
                    //将月份数清0
                    count = 0;
                    //将总房价清0
                    sum = 0;
                }
            }
            count++;
            sum += Integer.parseInt(csvReader.get(4));
        }

        //读到了最后一行
        set.add(sId + " " + preYear + " " + sum/count);
        return set;
    }
}
