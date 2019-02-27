package edu.seu.housepricepredict.pojo.year;

/**
 * @author guodonwu@163.com
 * @date 14:21 2019/2/27
 * 城市历史年份房价
 */

public class CityYearPrice {
    private int cId;
    private int year;
    private int price;

    @Override
    public String toString() {
        return "CityYearPrice{" +
                "cId=" + cId +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
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
