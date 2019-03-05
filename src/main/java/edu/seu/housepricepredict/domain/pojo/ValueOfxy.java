package edu.seu.housepricepredict.domain.pojo;

public class ValueOfxy {
    private String x;
    private Integer y1;
    private Integer y2;

    public ValueOfxy() {
    }

    public ValueOfxy(String x, Integer y1, Integer y2) {
        this.x = x;
        this.y1 = y1;
        this.y2 = y2;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }
}
