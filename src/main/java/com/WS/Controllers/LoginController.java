/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Auth.TokenHandler;
import com.WS.Config.SHA256PasswordEncoder;
import com.WS.Entity.Authority;
import com.WS.Entity.User;
import com.WS.Repository.UserRepository;
import com.WS.Service.SecurityContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping(path = "/api/account")
public class LoginController {
    /**
     * spring boot auth manager to ensure user autherize tokens
     */
    private final AuthenticationManager authenticationManager;
    /**
     * Used to create tokens to send to the user
     */
    private final TokenHandler tokenHandler;
    /**
     * current Security context used for security and permissions
     */
    private final SecurityContextService securityContextService;
    /**
     * User repository used for the Users table
     */
    private final UserRepository userRepository;
    /**
     * Used for encoding passwords for storage
     */
    private SHA256PasswordEncoder sha256PasswordEncoder;

    /**
     * 
     * @param authenticationManager spring boot auth manager to ensure user autherize tokens
     * @param tokenHandler Used to create tokens to send to the user
     * @param securityContextService current Security context used for security and permissions
     * @param userRepository User repository used for the Users table
     * @param sha256PasswordEncoder Used for encoding passwords for storage
     */
    @Autowired
    public LoginController(AuthenticationManager authenticationManager,
                           TokenHandler tokenHandler,
                           SecurityContextService securityContextService,
                           UserRepository userRepository,
                           SHA256PasswordEncoder sha256PasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.tokenHandler = tokenHandler;
        this.securityContextService = securityContextService;
        this.userRepository = userRepository;
        this.sha256PasswordEncoder = sha256PasswordEncoder;
    }

    /**
     * HTTP request for logging in
     * @param params user data for attempted login for autherization 
     * @return AuthResponse which contains the token for the user's session
     * @throws AuthenticationException 
     */
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthParams params) throws AuthenticationException {
        final UsernamePasswordAuthenticationToken loginToken = params.toAuthenticationToken();
        final Authentication authentication = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return securityContextService.currentUser().map(u -> {
            final String token = tokenHandler.createTokenForUser(u);
            return new AuthResponse(token);
        }).orElseThrow(RuntimeException::new); // it does not happen.
    }

    /**
     * 
     * @param signupParams User data being used for creation of a new account
     * @return a boolean on whether or not account creation was successful 
     */
    @PostMapping("/signup")
    public boolean signUp(@RequestBody SignupParams signupParams) {
        Authority authority = new Authority();
        authority.setId(1);
        authority.setAuthority("basic");
        User newUser = new User(signupParams.username, sha256PasswordEncoder.encode(signupParams.password), authority);
        User userWithName = userRepository.findByUsername(newUser.getUsername());
        if (userWithName == null) {
            userRepository.save(newUser);
            return true;
        }
        return false;

    }

    private static final class AuthParams {
        private String username;
        private String password;

        public AuthParams() {
        }

        public AuthParams(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        UsernamePasswordAuthenticationToken toAuthenticationToken() {
            return new UsernamePasswordAuthenticationToken(username, password);
        }
    }

    private static final class AuthResponse {
        private String token;

        public AuthResponse() {
        }

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    private static final class SignupParams {
        private String username;
        private String password;

        public SignupParams() {
        }

        public SignupParams(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
