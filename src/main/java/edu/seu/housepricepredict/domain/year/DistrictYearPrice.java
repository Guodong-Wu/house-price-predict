package edu.seu.housepricepredict.domain.year;

/**
 * @author guodonwu@163.com
 * @date 14:21 2019/2/27
 * 行政区历史年份房价
 */

public class DistrictYearPrice {
    private int dId;
    private int year;
    private int price;

    @Override
    public String toString() {
        return "DistrictYearPrice{" +
                "dId=" + dId +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
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
