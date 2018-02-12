package upc.opendinghall.project.start.util;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import upc.opendinghall.project.start.dto.AccessToken;
import upc.opendinghall.project.start.dto.JwtUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/12  21:28
 */
public class JwtFilter implements Filter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    protected Subject getSubject(ServletRequest request, ServletResponse response) {
        return SecurityUtils.getSubject();
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                filterConfig.getServletContext());

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        String authToken =httpRequest.getHeader("Authorization");
        System.out.println("传入的token是 " + authToken);

        System.out.println("token =====>" + authToken);


        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        System.out.println("username" + username);

        System.out.println("niah");
        //UserInfo userInfo = userInfoService.findByUsername(username);
        String Tel = jwtTokenUtil.getTelFromToken(authToken);
        //这个问题后面来改  只能是通过某个参数看另外一个参数是否正确
        //这里应该只能是通过  Tel  来数据库找username  再用下面这个方法来验证其中的username的正确性。
        AccessToken token = new AccessToken(authToken);
        getSubject(request, response).login(token);
        System.out.println("登陆成功");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
