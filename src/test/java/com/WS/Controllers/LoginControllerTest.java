package com.WS.Controllers;

import com.WS.Entity.Authority;
import com.WS.Entity.User;
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

//    @Test
//    public void testLoginNonExistentUser() throws UnsupportedEncodingException {
//        // RemoteService has been injected into the reverser bean
//        /*
//        given(this.remoteService.someCall()).willReturn("mock");
//        String reverse = reverser.reverseSomeCall();
//        assertThat(reverse).isEqualTo("kcom");
//        */
//        Authority p = new Authority();
//        p.setId(2);
//        p.setAuthority("basic");
//        User test = new User();
//        test.setUsername("testing");
//        test.setPassword("test");
//        test.setAuthority(p);
//        assertThat(loginController.login(test)).isEqualTo(null);
//    }
//
//    @Test
//    public void testLoginExistingUser() throws UnsupportedEncodingException {
//        Authority p = new Authority();
//        p.setId(2);
//        p.setAuthority("basic");
//        User test = new User();
//        test.setUsername("test");
//        test.setPassword("test");
//        test.setAuthority(p);
//        assertThat(loginController.login(test)).isNotEqualTo(null);
//    }


}