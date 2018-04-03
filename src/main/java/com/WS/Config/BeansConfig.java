/**
 * Code courtesy of Jakub Remenec (https://blog.davincisoftware.sk/blog-angular-and-spring-security-integration-part1)
 */
package com.WS.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public SHA256PasswordEncoder sha256PasswordEncoder() {
        return new SHA256PasswordEncoder();
    }

}
