/**
 * Code courtesy of Jakub Remenec (https://blog.davincisoftware.sk/blog-angular-and-spring-security-integration-part1)
 * with modifications by Adrian Bolt
 */
package com.WS.Auth;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface TokenAuthenticationService {

    Authentication getAuthentication(HttpServletRequest request);
}