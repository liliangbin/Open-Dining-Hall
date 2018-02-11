package upc.opendinghall.project.start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.opendinghall.project.start.model.SysPermission;
import upc.opendinghall.project.start.model.SysRole;
import upc.opendinghall.project.start.model.UserInfo;
import upc.opendinghall.project.start.repository.UserInfoRepository;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/11  23:25
 */

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo findByUsername(String username) {

        UserInfo userInfo = userInfoRepository.findByUsername(username);
        if (userInfo.getRoleList() != null && userInfo.getRoleList().size() != 0) {
            for (SysRole role : userInfo.getRoleList()) {
                role.setUserInfos(null);
                Iterable<SysPermission> sysPermissions = role.getPermissions();
                for(SysPermission sysPermission : role.getPermissions()){
                    sysPermission.setRoles(null);
                }
            }
        }
        return userInfo;

    }
}
