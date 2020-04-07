package com.heyi.netty.smartiot;

import com.heyi.netty.smartiot.server.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartiotApplication {
    private static final Logger log = LoggerFactory.getLogger(SmartiotApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SmartiotApplication.class, args);
        run();
    }

    private static NettyServer nettyServer = new NettyServer();

    private static void run() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                nettyServer.run();
            }
        });
        thread.start();

    }
}