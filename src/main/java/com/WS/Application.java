package com.WS;

import com.WS.DAOs.IngredientDAO;
import com.WS.DAOs.RecipeDAO;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class Application {
    private final String host;
    private Integer port = 8090;

    public Application(@Value("${socketio.host}") final String host) {
        this.host = host;
    }
    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setHostname(host);
        config.setPort(port);
        return new SocketIOServer(config);
    }
    
    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer ssrv) {
        return new SpringAnnotationScanner(ssrv);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
