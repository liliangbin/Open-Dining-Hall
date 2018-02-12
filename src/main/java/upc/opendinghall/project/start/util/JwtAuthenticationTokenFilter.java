package upc.opendinghall.project.start.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import upc.opendinghall.project.start.dto.AccessToken;
import upc.opendinghall.project.start.dto.JwtUser;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/12  0:17
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    protected Subject getSubject(ServletRequest request, ServletResponse response) {
        return SecurityUtils.getSubject();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authToken = request.getHeader("Authorization");
        System.out.println("传入的token是 " + authToken);
        AccessToken token = new AccessToken(authToken);
        getSubject(request, response).login(token);
        System.out.println("登陆成功");
        System.out.println("token =====>" + authToken);
        try {
            String Tel = jwtTokenUtil.getTelFromToken(authToken);
            System.out.println("电话号码是：" + Tel);
        } catch (Exception e) {

            System.out.println(e.getMessage()  + "jwttokenutil");
        }
        //System.out.println("tel ====>" + Tel);
   /*     String Tel = jwtTokenUtil.getTelFromToken(authToken);
        String username = jwtTokenUtil.getUsernameFromToken(authToken);

        //这个问题后面来改  只能是通过某个参数看另外一个参数是否正确
        //这里应该只能是通过  Tel  来数据库找username  再用下面这个方法来验证其中的username的正确性。
        if (Tel != null && username != null) {
            JwtUser jwtUser = new JwtUser(Tel, username);
            if (jwtTokenUtil.validateToken(authToken, jwtUser)) {
                System.out.println("在filter 这里面   authtoken is:" + authToken);
                AccessToken token = new AccessToken(authToken);
                getSubject(request, response).login(token);
                System.out.println("登陆成功");
            }
        }*/

        chain.doFilter(request, response);


    }
}

