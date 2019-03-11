package edu.seu.housepricepredict.domain.pojo.area;


/**
 * @author guodonwu@163.com
 * @date 10:39 2019/2/27
 * 街道
 */

public class Street {
    private int id;
    private String name;
    private int price;

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

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
}
