package edu.seu.housepricepredict.service;

import java.io.IOException;

/**
 * @author guodonwu@163.com
 * @date 14:14 2019/3/5
 * 导入数据的接口
 */

public interface ImportDataService {

    void insertCity(String fileName) throws IOException;

    void insertDistrict(String fileName) throws IOException;

    void insertStreet(String fileName) throws IOException;

    void insertCommunity(String fileName) throws IOException;

    void insertStreetMonthPrice(String fileName) throws IOException;

    void insertDistrictMonthPrice();

    void insertCityMonthPrice();

    void updateCityPrice();

    void updateDistrictPrice();

    void updateStreetPrice();

    void insertStreetYearPrice(String fileName) throws IOException;

    void insertDistrictYearPrice();

    void insertCityYearPrice();

    void insertStreetPredictPrice(String fileName) throws IOException;

    void insertDistrictPredictPrice();

    void insertCityPredictPrice();

}
