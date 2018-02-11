package upc.opendinghall.project.start.dto;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/11  23:54
 */
public class JwtUser {


    private  String username;
    private  String tel;

    public JwtUser(String username, String tel) {
        this.username = username;
        this.tel = tel;
    }

    public JwtUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
