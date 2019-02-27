package edu.seu.housepricepredict.pojo.month;

/**
 * @author guodonwu@163.com
 * @date 14:19 2019/2/27
 * 城市历史月份房价
 */

public class CityMonthPrice {
    private int cId;
    private int month;
    private int price;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
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

    @Override
    public String toString() {
        return "CityMonthPrice{" +
                "cId=" + cId +
                ", month=" + month +
                ", price=" + price +
                '}';
    }
}
