package upc.opendinghall.project.start.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderid;//订单id


    @Column(unique = true)
    private String userbuyerid;//买家用户id
    private String userdisid;//配送员用户id
    private String useradd;//配送地址
    private String orderdis;//订单描述
    private String orderstate;//订单状态
    private String orderassess;//订单评价
    private String orderprice;//订单价格
    private String ordertype;//订单类型


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getUserbuyerid() {
        return userbuyerid;
    }

    public void setUserbuyerid(String userbuyerid) {
        this.userbuyerid = userbuyerid;
    }

    public String getUserdisid() {
        return userdisid;
    }

    public void setUserdisid(String userdisid) {
        this.userdisid = userdisid;
    }

    public String getUseradd() {
        return useradd;
    }

    public void setUseradd(String useradd) {
        this.useradd = useradd;
    }

    public String getOrderdis() {
        return orderdis;
    }

    public void setOrderdis(String orderdis) {
        this.orderdis = orderdis;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public String getOrderassess() {
        return orderassess;
    }

    public void setOrderassess(String orderassess) {
        this.orderassess = orderassess;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderid=" + orderid +
                ", userbuyerid='" + userbuyerid + '\'' +
                ", userdisid='" + userdisid + '\'' +
                ", useradd='" + useradd + '\'' +
                ", orderdis='" + orderdis + '\'' +
                ", orderstate=" + orderstate +
                ", orderassess='" + orderassess + '\'' +
                ", orderprice='" + orderprice + '\'' +
                ", ordertype='" + ordertype +
                '}';
    }
}