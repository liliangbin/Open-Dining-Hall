package upc.opendinghall.project.start.controller;

import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    UserInfoRepository userInfoRepository;

    @ApiOperation(value = "用于查找", notes = "chazhao shuju")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "message1", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "message2", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "id", value = "该条数据的id", required = true, dataType = "String")})
    @GetMapping("/user")
    @RequiresAuthentication
    public Object requireAuthentication() {

        return new ResponseBean(1, "已经授权后接口", null);

    }


    @ApiOperation(value = "/name", notes = "")
    @GetMapping("/name")
    @RequiresRoles("admin")
    public Object requireRole() {
        return new ResponseBean(1, "该用户拥有角色  ‘admin’ ", null);
    }

    @ResponseBody
    @GetMapping("/getuser")
    @RequiresPermissions("userInfo:add")
    public ResponseEntity<?> getuser() {
        UserInfo userInfo = userInfoRepository.findByUsername("admin");
        System.out.println(userInfo.getRoleList());
        return ResponseEntity
                .ok()
                .body(userInfo);

    }
    @GetMapping("/test")
    public String test(){
        return  "测试接口";
    }
}
