
package upc.opendinghall.project.start.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FoodInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    public long getFoodid() {
        return foodid;
    }

    public void setFoodid(long foodid) {
        this.foodid = foodid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long foodid;


    @Column(unique = true)
    private String foodname;
    private String foodprice;
    private String fooddes;
    private String foodlist;
    private String foodweekstate;
    private String foodstate;
    private String foodplace;
    private String foodlistamount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(String foodprice) {
        this.foodprice = foodprice;
    }

    public String getFooddes() {
        return fooddes;
    }

    public void setFooddes(String fooddes) {
        this.fooddes = fooddes;
    }

    public String getFoodlist() {
        return foodlist;
    }

    public void setFoodlist(String foodlist) {
        this.foodlist = foodlist;
    }

    public String getFoodweekstate() {
        return foodweekstate;
    }

    public void setFoodweekstate(String foodweekstate) {
        this.foodweekstate = foodweekstate;
    }

    public String getFoodstate() {
        return foodstate;
    }

    public void setFoodstate(String foodstate) {
        this.foodstate = foodstate;
    }

    public String getFoodplace() {
        return foodplace;
    }

    public void setFoodplace(String foodplace) {
        this.foodplace = foodplace;
    }

    public String getFoodlistamount() {
        return foodlistamount;
    }

    public void setFoodlistamount(String foodlistamount) {
        this.foodlistamount = foodlistamount;
    }

    public String getFoodlabel() {
        return foodlabel;
    }

    public void setFoodlabel(String foodlabel) {
        this.foodlabel = foodlabel;
    }


    public String getPlaceid() {
        return placeid;
    }

    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }

    private String foodlabel;
    private String placeid;
    private String sellerid;

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }


    @Override
    public String toString() {

        return "foodinfo{" +
                "foodid=" + foodid +
                ", foodname='" + foodname + '\'' +
                ", foodprice='" + foodprice + '\'' +
                ", fooddes='" + fooddes + '\'' +
                ", foodlist='" + foodlist + '\'' +
                ", foodweekstate=" + foodweekstate +
                ", foodstate='" + foodstate + '\'' +
                ", foodplace='" + foodplace + '\'' +
                ", foodlistamount='" + foodlistamount + '\'' +
                ", foodlabel='" + foodlabel + '\'' +
                ", placeid=" + placeid + '\'' +
                ", sellerid=" + sellerid +
                '}';
    }
}


