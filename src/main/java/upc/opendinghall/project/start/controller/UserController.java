package upc.opendinghall.project.start.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import upc.opendinghall.project.start.model.UserInfo;
import upc.opendinghall.project.start.repository.UserInfoRepository;
import upc.opendinghall.project.start.util.ResponseBean;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/12  14:19
 */
@RestController
public class UserController {


    @Autowired
    UserInfoRepository userInfoRepository ;

    @GetMapping("/user")
    @RequiresAuthentication
    public Object requireAuthentication() {

        return new ResponseBean(1, "已经授权后接口", null);

    }


    @GetMapping("/name")
    @RequiresRoles("admin")

    public Object requireRole() {
        return new ResponseBean(1, "该用户拥有角色  ‘admin’ ", null);


    }

    @GetMapping("/getuser")
    public Object getuser(){
        UserInfo userInfo = userInfoRepository.findByUsername("admin");

        System.out.println(userInfo.getRoleList());
        return userInfo;
    }
}
