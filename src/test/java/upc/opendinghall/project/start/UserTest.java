package upc.opendinghall.project.start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import upc.opendinghall.project.start.model.UserInfo;
import upc.opendinghall.project.start.repository.UserInfoRepository;
import upc.opendinghall.project.start.service.UserInfoService;
import upc.opendinghall.project.start.util.JwtTokenUtil;
import upc.opendinghall.project.start.util.MyUtils;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/12  1:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    final  String token = "eyJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVkIjoxNTE4NDIwMzM4NTE2LCJ0ZWwiOiIxNzg1NDIyNjk4NCIsImV4cCI6MTUxOTAyNTEzOCwidXNlcm5hbWUiOiJhZG1pbiJ9.LLnw93Ktt-JgBdkhPY9g-qWHexWQ9V_jh_duKt31YMwTNeAMfKETOOJWlpaXwMdHrPT_PbN5X8od8ll52V_xBw";
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoRepository userInfoRepository;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Test
    public void register() {

        UserInfo userInfo = new UserInfo();
        userInfo.setTel("17854226984");
        userInfo.setUsername("admin");
        userInfo.setSalt("nana");
        String password = "123456";
        String nam = MyUtils.getMD5(password + userInfo.getCredentialsSalt());
        userInfo.setPassword(nam);
        userInfoRepository.save(userInfo);

    }


    @Test
    public void  filter (){

   String tel =     jwtTokenUtil.getTelFromToken(token);

        System.out.println(tel);
    }

    @Test
    public void  ff(){
     UserInfo userInfo=   userInfoService.findByUsername("admin");
        userInfo.getRoleList();

        System.out.println(userInfo);
    }

}
