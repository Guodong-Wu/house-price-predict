package edu.seu.housepricepredict.pojo.area;

import edu.seu.housepricepredict.pojo.month.CityMonthPrice;
import edu.seu.housepricepredict.pojo.year.CityYearPrice;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:13 2019/2/27
 * 城市
 */

public class City {

    private int cId;
    private String cName;
    private int cPrice;
    private List<District> districts;
    private List<CityMonthPrice> monthPrices;
    private List<CityYearPrice> yearPrices;

    @Override
    public String toString() {
        return "City{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cPrice=" + cPrice +
                ", districts=" + districts +
                ", monthPrices=" + monthPrices +
                ", yearPrices=" + yearPrices +
                '}';
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcPrice() {
        return cPrice;
    }

    public void setcPrice(int cPrice) {
        this.cPrice = cPrice;
    }

    public List<CityMonthPrice> getMonthPrices() {
        return monthPrices;
    }

    public void setMonthPrices(List<CityMonthPrice> monthPrices) {
        this.monthPrices = monthPrices;
    }

    public List<CityYearPrice> getYearPrices() {
        return yearPrices;
    }

    public void setYearPrices(List<CityYearPrice> yearPrices) {
        this.yearPrices = yearPrices;
    }
}
