/*
  Code courtesy of Jakub Remenec (https://blog.davincisoftware.sk/blog-angular-and-spring-security-integration-part1)
  with modifications by Adrian Bolt
 */
package com.WS.Service;

import com.WS.Entity.User;

import java.util.Optional;

public interface SecurityContextService {

    Optional<User> currentUser();

}