package edu.seu.housepricepredict.domain.area;

/**
 * @author guodonwu@163.com
 * @date 10:13 2019/2/27
 * 城市
 */

public class City {

    private int id;
    private String name;
    private int price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
