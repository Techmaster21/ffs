package com.WS.Controllers;

import com.WS.Entity.Ffser;
import com.WS.Entity.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

    @Autowired
    private LoginController loginController;

    @Test
    public void testLoginNonExistentUser() throws UnsupportedEncodingException {
        // RemoteService has been injected into the reverser bean
        /*
        given(this.remoteService.someCall()).willReturn("mock");
        String reverse = reverser.reverseSomeCall();
        assertThat(reverse).isEqualTo("kcom");
        */
        Permission p = new Permission();
        p.setId(2);
        p.setTitle("basic");
        Ffser test = new Ffser();
        test.setUsername("testing");
        test.setPassword("test");
        test.setPermission(p);
        assertThat(loginController.login(test)).isEqualTo(null);
    }

    @Test
    public void testLoginExistingUser() throws UnsupportedEncodingException {
        Permission p = new Permission();
        p.setId(2);
        p.setTitle("basic");
        Ffser test = new Ffser();
        test.setUsername("test");
        test.setPassword("test");
        test.setPermission(p);
        assertThat(loginController.login(test)).isNotEqualTo(null);
    }


}