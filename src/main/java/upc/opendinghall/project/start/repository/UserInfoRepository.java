package upc.opendinghall.project.start.repository;

import org.springframework.data.repository.CrudRepository;
import upc.opendinghall.project.start.model.UserInfo;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/11  23:15
 */
public interface UserInfoRepository  extends CrudRepository<UserInfo,Long>{
    public UserInfo findByUsername(String username);

}
