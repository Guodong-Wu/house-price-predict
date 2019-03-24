package edu.seu.housepricepredict.domain.increase;

/**
 * @author guodonwu@163.com
 * @date 14:43 2019/3/24
 */

public class DistrictIncrease {
    private int id;
    private int month;
    private double increase;

    @Override
    public String toString() {
        return "StreetIncrease{" +
                "id=" + id +
                ", month=" + month +
                ", increase=" + increase +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getIncrease() {
        return increase;
    }

    public void setIncrease(double increase) {
        this.increase = increase;
    }
}
