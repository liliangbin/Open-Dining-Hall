package upc.opendinghall.project.start.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.opendinghall.project.start.dto.JwtUser;
import upc.opendinghall.project.start.model.SysPermission;
import upc.opendinghall.project.start.model.SysRole;
import upc.opendinghall.project.start.model.UserInfo;
import upc.opendinghall.project.start.repository.UserInfoRepository;
import upc.opendinghall.project.start.util.JwtTokenUtil;

import java.util.Date;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/12  19:30
 */
@Service
public class TokenService {



    private  static String secret = "mySecret";
    @Autowired
    private static UserInfoRepository userInfoRepository;


    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public static String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.get("username").toString();
        } catch (Exception e) {
            username = null;
        }

        return username;
    }

    public static Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get("create"));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public static Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }


    public static String getTelFromToken(String token) {
        String Tel;
        try {
            final Claims claims = getClaimsFromToken(token);
            System.out.println("通过token  查询  tel");
            Tel = claims.get("tel").toString();
        } catch (Exception e) {
            Tel = null;
        }
        System.out.println("在  filter 中的  tel值" + Tel);
        return Tel;
    }
    public static Boolean validateToken(String token){

        return (!isTokenExpired(token)
        );
    }

    private  static Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }


    public static UserInfo findByname(String username){

        UserInfo userInfo = userInfoRepository.findByUsername(username);
        if (userInfo.getRoleList() != null && userInfo.getRoleList().size() != 0) {
            for (SysRole role : userInfo.getRoleList()) {
                role.setUserInfos(null);
                System.out.println("jue");
                Iterable<SysPermission> sysPermissions = role.getPermissions();
                for (SysPermission sysPermission : role.getPermissions()) {
                    sysPermission.setRoles(null);
                }
            }
        }
        return userInfo;


    }

}
