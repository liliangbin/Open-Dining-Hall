package upc.opendinghall.project.start.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/11  23:07
 */

@Entity
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;//用户的id

    @Column(unique = true)
    private String username;//账号
    private String name;//昵称或是真实的名字。
    private String password;//密码
    private String salt;//加密密码的盐；
    private byte state;//用户状态的，0创建未认证，（比如，没有激活，没有输入验证码等等）--等待用户的验证  1，正常的状态，2，用户被锁定
    private String gender;
    private String tel;//唯一的一个东西，作为最重要的东西来弄
    private String location;
    private String portraitURL;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPortraitURL() {
        return portraitURL;
    }

    public void setPortraitURL(String portraitURL) {
        this.portraitURL = portraitURL;
    }


    @ManyToMany(fetch = FetchType.EAGER)//立即重数据库中加载数据。
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    @JsonIgnore
    private List<SysRole> roleList;//一个用户具有多个角色

    public long getUid() {
        return id;
    }

    public void setUid(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @JsonIgnore
    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    /**
     * 密码盐.
     *
     * @return
     */

    public String getCredentialsSalt() {

        return this.username + this.salt;

    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", location='" + location + '\'' +
                ", portraitURL='" + portraitURL + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}