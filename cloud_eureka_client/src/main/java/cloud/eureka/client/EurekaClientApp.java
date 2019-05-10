package cloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Created with IDEA
 * @author: yanliang
 * @Date: 2019/5/9
 * @Time: 10:02
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaClientApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApp.class);
    }
}
