
package upc.opendinghall.project.start.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class SellerInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sellerid;//卖家id

    @Column(unique = true)
    private String sellername;
    private String sellerpic;//卖家图片


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getSellerid() {
        return sellerid;
    }

    public void setSellerid(long sellerid) {
        this.sellerid = sellerid;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

    public String getSellerpic() {
        return sellerpic;
    }

    public void setSellerpic(String sellerpic) {
        this.sellerpic = sellerpic;
    }


    public String toString() {
        return "SellerInfo{" +
                "sellerid=" + sellerid +
                ", sellername='" + sellername + '\'' +
                ", sellerpic='" + sellerpic +
                '}';
    }
}