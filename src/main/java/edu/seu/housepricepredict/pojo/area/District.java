package edu.seu.housepricepredict.pojo.area;

import edu.seu.housepricepredict.pojo.month.DistrictMonthPrice;
import edu.seu.housepricepredict.pojo.year.DistrictYearPrice;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:40 2019/2/27
 * 行政区
 */

public class District {
    private int dId;
    private String dName;
    private int dPrice;
    private List<Street> streets;
    private List<DistrictMonthPrice> monthPrices;
    private List<DistrictYearPrice> yearPrices;

    @Override
    public String toString() {
        return "District{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dPrice=" + dPrice +
                ", streets=" + streets +
                ", monthPrices=" + monthPrices +
                ", yearPrices=" + yearPrices +
                '}';
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public int getdPrice() {
        return dPrice;
    }

    public void setdPrice(int dPrice) {
        this.dPrice = dPrice;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    public List<DistrictMonthPrice> getMonthPrices() {
        return monthPrices;
    }

    public void setMonthPrices(List<DistrictMonthPrice> monthPrices) {
        this.monthPrices = monthPrices;
    }

    public List<DistrictYearPrice> getYearPrices() {
        return yearPrices;
    }

    public void setYearPrices(List<DistrictYearPrice> yearPrices) {
        this.yearPrices = yearPrices;
    }
}
