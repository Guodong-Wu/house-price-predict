package edu.seu.housepricepredict.pojo.area;

import edu.seu.housepricepredict.pojo.month.CommunityMonthPrice;
import edu.seu.housepricepredict.pojo.year.CommunityYearPrice;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 10:39 2019/2/27
 * 街道
 */

public class Street {
    private int sId;
    private String sName;
    private int sPrice;
    private List<Community> communities;
    private List<CommunityMonthPrice> communityMonthPrices;
    private List<CommunityYearPrice> yearPrices;

    @Override
    public String toString() {
        return "Street{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sPrice=" + sPrice +
                ", communities=" + communities +
                ", communityMonthPrices=" + communityMonthPrices +
                ", yearPrices=" + yearPrices +
                '}';
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsPrice() {
        return sPrice;
    }

    public void setsPrice(int sPrice) {
        this.sPrice = sPrice;
    }

    public List<Community> getCommunities() {
        return communities;
    }

    public void setCommunities(List<Community> communities) {
        this.communities = communities;
    }

    public List<CommunityMonthPrice> getCommunityMonthPrices() {
        return communityMonthPrices;
    }

    public void setCommunityMonthPrices(List<CommunityMonthPrice> communityMonthPrices) {
        this.communityMonthPrices = communityMonthPrices;
    }

    public List<CommunityYearPrice> getYearPrices() {
        return yearPrices;
    }

    public void setYearPrices(List<CommunityYearPrice> yearPrices) {
        this.yearPrices = yearPrices;
    }
}
