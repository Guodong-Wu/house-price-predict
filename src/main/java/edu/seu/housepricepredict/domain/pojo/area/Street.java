package edu.seu.housepricepredict.domain.pojo.area;


/**
 * @author guodonwu@163.com
 * @date 10:39 2019/2/27
 * 街道
 */

public class Street {
    private int sId;
    private String sName;
    private int sPrice;

    @Override
    public String toString() {
        return "Street{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sPrice=" + sPrice +
                '}';
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsPrice() {
        return sPrice;
    }

    public void setsPrice(int sPrice) {
        this.sPrice = sPrice;
    }

}
