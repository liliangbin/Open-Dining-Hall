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
import upc.opendinghall.project.start.util.MyUtils;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/12  1:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoRepository userInfoRepository;

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

}
