package edu.seu.housepricepredict.domain.pojo.month;

/**
 * @author guodonwu@163.com
 * @date 14:20 2019/2/27
 * 行政区历史月份房价
 */

public class DistrictMonthPrice {
    private int dId;
    private int month;
    private int price;

    @Override
    public String toString() {
        return "DistrictMonthPrice{" +
                "dId=" + dId +
                ", month=" + month +
                ", price=" + price +
                '}';
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
