package com.WS.Controllers;

import com.WS.Entity.Ffser;
import com.WS.Entity.Permission;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

    @Autowired
    SocketIOServer server;

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