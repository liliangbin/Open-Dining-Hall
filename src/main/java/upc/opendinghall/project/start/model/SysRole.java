package upc.opendinghall.project.start.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/11  23:10
 */

@Entity
public class SysRole  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;//编号
    private String role; //角色标识程序中判断使用，如"admin"这个是唯一的
    private String description;//角色描述，Ui展示界面使用6
    private Boolean available = Boolean.FALSE;//是否可用，如果不能用就不会添加给用户。
    //角色----权限关系 。多对多的关系。
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermission> permissions;

    //用户--角色关系定义
    @ManyToMany
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "userId")})
    private List<UserInfo> userInfos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    //@JsonIgnore
    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

//@JsonBackReference

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", permissions=" + permissions +
                ", userInfos=" + userInfos +
                '}';
    }
}

