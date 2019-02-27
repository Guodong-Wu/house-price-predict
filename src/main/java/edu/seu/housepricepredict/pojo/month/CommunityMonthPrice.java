package edu.seu.housepricepredict.pojo.month;

/**
 * @author guodonwu@163.com
 * @date 14:19 2019/2/27
 * 小区历史月份房价
 */

public class CommunityMonthPrice {
    private int coId;
    private int year;
    private int month;
    private int price;

    @Override
    public String toString() {
        return "CommunityMonthPrice{" +
                "coId=" + coId +
                ", year=" + year +
                ", month=" + month +
                ", price=" + price +
                '}';
    }

    public int getCoId() {
        return coId;
    }

    public void setCoId(int coId) {
        this.coId = coId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
