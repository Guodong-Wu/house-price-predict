package edu.seu.housepricepredict.domain.month;

/**
 * @author guodonwu@163.com
 * @date 14:19 2019/2/27
 * 小区历史月份房价
 */

public class CommunityMonthPrice {
    private int coId;
    private int month;
    private int price;

    @Override
    public String toString() {
        return "CommunityMonthPrice{" +
                "coId=" + coId +
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