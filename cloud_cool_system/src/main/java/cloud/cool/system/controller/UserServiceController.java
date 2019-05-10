package cloud.cool.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created with IDEA
 * @author: yanliang
 * @Date: 2019/5/9
 * @Time: 10:44
 * @Description:
 */
@RestController
@RequestMapping("/rest/user")
public class UserServiceController {

    @GetMapping(value = {"/info"})
    public String info(){
        return "hello world";
    }
}
