package edu.seu.housepricepredict.pojo.month;

/**
 * @author guodonwu@163.com
 * @date 14:20 2019/2/27
 * 街道历史月份房价
 */

public class StreetMonthPrice {
    private int sId;
    private int month;
    private int price;

    @Override
    public String toString() {
        return "StreetMonthPrice{" +
                "sId=" + sId +
                ", month=" + month +
                ", price=" + price +
                '}';
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
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
