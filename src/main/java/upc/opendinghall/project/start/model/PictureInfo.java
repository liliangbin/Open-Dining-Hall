
package upc.opendinghall.project.start.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PictureInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long foodid;


    @Column(unique = true)
    private String pictureid;
    private String pictureroute;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getFoodid() {
        return foodid;
    }

    public void setFoodid(long foodid) {
        this.foodid = foodid;
    }

    public String getPictureid() {
        return pictureid;
    }

    public void setPictureid(String pictureid) {
        this.pictureid = pictureid;
    }

    public String getPictureroute() {
        return pictureroute;
    }

    public void setPictureroute(String pictureroute) {
        this.pictureroute = pictureroute;
    }


    @Override
    public String toString() {

        return "PictureInfo{" +
                "foodid=" + foodid +
                ", pictureid='" + pictureid + '\'' +
                ", pictureroute='" + pictureroute +
                '}';
    }
}