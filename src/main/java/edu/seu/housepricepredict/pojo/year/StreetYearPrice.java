package edu.seu.housepricepredict.pojo.year;

/**
 * @author guodonwu@163.com
 * @date 14:22 2019/2/27
 * 街道历史年份房价
 */

public class StreetYearPrice {
    private int sId;
    private int year;
    private int price;

    @Override
    public String toString() {
        return "StreetYearPrice{" +
                "sId=" + sId +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
