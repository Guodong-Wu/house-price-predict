package edu.seu.housepricepredict.domain.pojo.area;

/**
 * @author guodonwu@163.com
 * @date 10:13 2019/2/27
 * 城市
 */

public class City {

    private int cId;
    private String cName;
    private int cPrice;


    @Override
    public String toString() {
        return "City{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cPrice=" + cPrice +
                '}';
    }


    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcPrice() {
        return cPrice;
    }

    public void setcPrice(int cPrice) {
        this.cPrice = cPrice;
    }


}
