/*
  Code courtesy of Jakub Remenec (https://blog.davincisoftware.sk/blog-angular-and-spring-security-integration-part1)
  with modifications by Adrian Bolt
 */
package com.WS.Config;

import com.WS.Auth.TokenAuthenticationService;
import io.jsonwebtoken.JwtException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component // one per request
public class StatelessAuthenticationFilter extends GenericFilterBean {

    private final TokenAuthenticationService tokenAuthenticationService;

    public StatelessAuthenticationFilter(TokenAuthenticationService tokenAuthenticationService) {
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        try {
            Authentication authentication = tokenAuthenticationService.getAuthentication((HttpServletRequest) req);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(req, res);
            SecurityContextHolder.getContext().setAuthentication(null);
        } catch (AuthenticationException | JwtException e) {
            SecurityContextHolder.clearContext();
            ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}