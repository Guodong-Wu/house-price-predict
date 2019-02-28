package edu.seu.housepricepredict.domain.pojo.area;

/**
 * @author guodonwu@163.com
 * @date 10:41 2019/2/27
 * 小区
 */

public class Community {
    private int coId;
    private String coName;
    private int coPrice;

    @Override
    public String toString() {
        return "Community{" +
                "coId=" + coId +
                ", coName='" + coName + '\'' +
                ", coPrice=" + coPrice +
                '}';
    }

    public int getCoId() {
        return coId;
    }

    public void setCoId(int coId) {
        this.coId = coId;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public int getCoPrice() {
        return coPrice;
    }

    public void setCoPrice(int coPrice) {
        this.coPrice = coPrice;
    }

}
