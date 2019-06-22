package cn.itcast.consumer.controller;

import cn.itcast.consumer.feign.UserFeignClient;
import cn.itcast.consumer.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xualin
 * @version v1.0
 * @date 2019/4/2 11:45
 * @description
 **/
@RestController
@RequestMapping("consumer")
@Slf4j
public class ConsumerController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userFeignClient.queryById(id);


    }

}
