package upc.opendinghall.project.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import upc.opendinghall.project.start.dto.JwtUser;
import upc.opendinghall.project.start.model.UserInfo;
import upc.opendinghall.project.start.service.UserInfoService;
import upc.opendinghall.project.start.util.JwtTokenUtil;
import upc.opendinghall.project.start.util.MyUtils;
import upc.opendinghall.project.start.util.ResponseBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/12  0:43
 */
@RestController
public class AuthController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public Object login(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserInfo userInfo = userInfoService.findByUsername(username);
        if (userInfo == null) {

            return new ResponseBean(1, "没有该用户", "null");

        }

        String secret = MyUtils.getMD5(password + userInfo.getCredentialsSalt());

        if (userInfo.getPassword().equals(secret)) {

            JwtUser jwtUser = new JwtUser( username,userInfo.getTel());
            final String token = jwtTokenUtil.generateToken(jwtUser);

            System.out.println("发放token  ：" + token);
            return token;
        } else {
            return new ResponseBean(2, "其他错误", null);
        }

    }

}
