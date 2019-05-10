package cloud.cool.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Created with IDEA
 * @author: yanliang
 * @Date: 2019/5/9
 * @Time: 15:43
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthorizationServerApp {

    private static Logger logger = LoggerFactory.getLogger(AuthorizationServerApp.class);

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApp.class);
        logger.info("【oauth2服务认证中心启动成功！】");
    }
}
