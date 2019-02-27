package edu.seu.housepricepredict.pojo.area;

import edu.seu.housepricepredict.pojo.month.CityMonthPrice;
import edu.seu.housepricepredict.pojo.month.CommunityMonthPrice;
import edu.seu.housepricepredict.pojo.year.CommunityYearPrice;

import java.time.Month;
import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:41 2019/2/27
 * 小区
 */

public class Community {
    private int coId;
    private String coName;
    private int coPrice;
    private List<CommunityMonthPrice> monthPrices;
    private List<CommunityYearPrice> yearPrices;

    @Override
    public String toString() {
        return "Community{" +
                "coId=" + coId +
                ", coName='" + coName + '\'' +
                ", coPrice=" + coPrice +
                ", monthPrices=" + monthPrices +
                ", yearPrices=" + yearPrices +
                '}';
    }

    public int getCoId() {
        return coId;
    }

    public void setCoId(int coId) {
        this.coId = coId;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public int getCoPrice() {
        return coPrice;
    }

    public void setCoPrice(int coPrice) {
        this.coPrice = coPrice;
    }

    public List<CommunityMonthPrice> getMonthPrices() {
        return monthPrices;
    }

    public void setMonthPrices(List<CommunityMonthPrice> monthPrices) {
        this.monthPrices = monthPrices;
    }

    public List<CommunityYearPrice> getYearPrices() {
        return yearPrices;
    }

    public void setYearPrices(List<CommunityYearPrice> yearPrices) {
        this.yearPrices = yearPrices;
    }
}
