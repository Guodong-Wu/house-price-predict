package edu.seu.housepricepredict.pojo.year;

/**
 * @author guodonwu@163.com
 * @date 14:21 2019/2/27
 * 小区历史年份房价
 */

public class CommunityYearPrice {
    private int coId;
    private int year;
    private int price;

    @Override
    public String toString() {
        return "CommunityYearPrice{" +
                "coId=" + coId +
                ", year=" + year +
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
