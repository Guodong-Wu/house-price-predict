package edu.seu.housepricepredict.utils;

/**
 * @author xg_song
 * @data 2019/3/12 14:06
 */

/**
 * 将两个小区的历史房价数据封装到该类中，以json数据传输。
 */
public class Value {
    //横坐标值（月份）
    private String dataOfx;
    //第一个小区该月份的房价
    private String dataOfy1;
    //第二个小区该月份的房价
    private String dataOfy2;

    @Override
    public String toString() {
        return "Value{" +
                "dataOfx='" + dataOfx + '\'' +
                ", dataOfy1='" + dataOfy1 + '\'' +
                ", dataOfy2='" + dataOfy2 + '\'' +
                '}';
    }

    public Value() {
    }

    public Value(String dataOfx, String dataOfy1, String dataOfy2) {
        this.dataOfx = dataOfx;
        this.dataOfy1 = dataOfy1;
        this.dataOfy2 = dataOfy2;
    }

    public String getDataOfx() {
        return dataOfx;
    }

    public void setDataOfx(String dataOfx) {
        this.dataOfx = dataOfx;
    }

    public String getDataOfy1() {
        return dataOfy1;
    }

    public void setDataOfy1(String dataOfy1) {
        this.dataOfy1 = dataOfy1;
    }

    public String getDataOfy2() {
        return dataOfy2;
    }

    public void setDataOfy2(String dataOfy2) {
        this.dataOfy2 = dataOfy2;
    }
}
