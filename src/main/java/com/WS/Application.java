package com.WS;

import com.WS.Repository.PantryRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;

@SpringBootApplication
@Controller
public class Application {
    private final String host;
    private Integer port = 8090;

    public Application(@Value("${socketio.host}") final String host) {
        this.host = host;
    }
    
    /**
     * Because Angular is a single page application and Apache Tomcat didn't get the memo, this forwards all non-static
     * (html, css, js, etc) paths to the root path (/) so that Angular can take it from there.
     * @return
     */
    /*
    @GetMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }
*/
    /**
     * Creates and configures the socket.io server. 
     * @return
     */
    @Bean
    public SocketIOServer socketIOServer() {
    		// configuration stuff
        Configuration config = new Configuration();
        config.setHostname(host);
        config.setPort(port);
        SocketConfig sockConfig = new SocketConfig();
        sockConfig.setReuseAddress(true);
        config.setSocketConfig(sockConfig);
        SocketIOServer server = new SocketIOServer(config);
        
        return server;
    }
    
    /*
     * This made the @OnEvent annotations work - problem is, it didn't work well with namespaces because 
     * the ssrv parameter passed in would be the socketio server with default namespace. So no matter what,
     * it would listen for every event on the default namespace, which kind of defeats the purpose of namespace
     * based authentication.
     * All it essentially does is call ssrv.addListeners(Object) for each object in which there is a SocketIO
     * annotation, so to make it work better with namespaces we now just do it manually in the Runner class.
     */
//    @Bean
//    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer ssrv) {
//        return new SpringAnnotationScanner(ssrv);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
