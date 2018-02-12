package upc.opendinghall.project.start.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import upc.opendinghall.project.start.dto.AccessToken;
import upc.opendinghall.project.start.dto.JwtUser;
import upc.opendinghall.project.start.model.UserInfo;
import upc.opendinghall.project.start.service.TokenService;
import upc.opendinghall.project.start.service.UserInfoService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/12  0:17
 */

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    protected Subject getSubject(ServletRequest request, ServletResponse response) {
        return SecurityUtils.getSubject();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authToken = request.getHeader("Authorization");

        String username = TokenService.getUsernameFromToken(authToken);
        if (username != null) {


            if (TokenService.validateToken(authToken)) {

                AccessToken token = new AccessToken(authToken);
                getSubject(request, response).login(token);
                System.out.println("登陆成功");
            }
        }
        chain.doFilter(request, response);


    }

}
