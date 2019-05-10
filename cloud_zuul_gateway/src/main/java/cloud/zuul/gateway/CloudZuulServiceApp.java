package cloud.zuul.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

//import java.security.Principal;

/**
 * @Created with IDEA
 * @author: yanliang
 * @Date: 2019/5/9
 * @Time: 10:24
 * @Description:
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@RestController
public class CloudZuulServiceApp {

    private static Logger logger = LoggerFactory.getLogger(CloudZuulServiceApp.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulServiceApp.class);
        logger.info("spring cloud gateway is running 。。。。。");
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    @RequestMapping("/")
    public String info(){
        return "welcome";
    }
    @Component
    @EnableOAuth2Sso
    @Order(0)
    public static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.
                    antMatcher("/**")
                    // 所有请求都得经过认证和授权
                    .authorizeRequests().anyRequest().authenticated()
                    .and().authorizeRequests().antMatchers("/","/anon").permitAll()
                    .and()
                    // 这里之所以要禁用csrf，是为了方便。
                    // 否则，退出链接必须要发送一个post请求，请求还得带csrf token
                    // 那样我还得写一个界面，发送post请求
                    .csrf().disable()
                    // 退出的URL是/logout
                    .logout().logoutUrl("/logout").permitAll()
                    // 退出成功后，跳转到/路径。
                    .logoutSuccessUrl("/login");
        }
    }
}
