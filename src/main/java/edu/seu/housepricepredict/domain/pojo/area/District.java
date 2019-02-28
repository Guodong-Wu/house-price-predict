package edu.seu.housepricepredict.domain.pojo.area;


/**
 * @author guodonwu@163.com
 * @date 10:40 2019/2/27
 * 行政区
 */

public class District {
    private int dId;
    private String dName;
    private int dPrice;

    @Override
    public String toString() {
        return "District{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dPrice=" + dPrice +
                '}';
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public int getdPrice() {
        return dPrice;
    }

    public void setdPrice(int dPrice) {
        this.dPrice = dPrice;
    }

}
