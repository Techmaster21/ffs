/**
 * Code courtesy of Jakub Remenec (https://blog.davincisoftware.sk/blog-angular-and-spring-security-integration-part1)
 * with modifications by Adrian Bolt
 */
package com.WS.Auth;

import com.WS.Entity.User;
import com.WS.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

@Component
public final class TokenHandlerImpl implements TokenHandler {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(TokenHandlerImpl.class);

    private final String secret;

    private final UserRepository userRepository;

    @Autowired
    public TokenHandlerImpl(@Value("${app.jwt.secret}") String secret,
                            UserRepository userRepository) {
        this.secret = secret;
        this.userRepository = userRepository;
    }

    public Optional<UserDetails> parseUserFromToken(String token) {
        final String subject = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        final User user = userRepository.findById(Integer.valueOf(subject)).get();

        return Optional.ofNullable(user);
    }

    public String createTokenForUser(User user) {
        final ZonedDateTime afterOneWeek = ZonedDateTime.now().plusWeeks(1);

        return Jwts.builder()
                .setSubject(user.getId() + "") // expiration + session
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(Date.from(afterOneWeek.toInstant()))
                .compact();
    }
}