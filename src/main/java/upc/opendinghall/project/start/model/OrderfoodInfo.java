
package upc.opendinghall.project.start.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class OrderfoodInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderid;//订单id

    public String getOrderfoodid() {
        return orderfoodid;
    }

    public void setOrderfoodid(String orderfoodid) {
        this.orderfoodid = orderfoodid;
    }

    @Column(unique = true)

    private String orderfoodid;//订单菜品id
    private String foodlist;//菜品清单
    private String quality;//质量

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }


    public String getFoodlist() {
        return foodlist;
    }


    public void setFoodlist(String foodlist) {
        this.foodlist = foodlist;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }


    @Override
    public String toString() {
        return "OrderfoodInfo{" +
                "orderid=" + orderid +
                ", orderfoodid='" + orderfoodid + '\'' +
                ", foodlist='" + foodlist + '\'' +
                ", quality='" + quality +
                '}';
    }


}
