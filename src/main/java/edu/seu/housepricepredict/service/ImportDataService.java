package edu.seu.housepricepredict.service;

import java.io.IOException;

/**
 * @author guodonwu@163.com
 * @date 14:14 2019/3/5
 * 导入数据的接口
 */

public interface ImportDataService {

    void insertCity() throws IOException;

    void insertDistrict() throws IOException;

    void insertStreet() throws IOException;

    void insertStreetMonthPrice() throws IOException;

    void insertDistrictMonthPrice();

    void insertCityMonthPrice();

    void updateCityPrice();

    void updateDistrictPrice();

    void updateStreetPrice();

}
