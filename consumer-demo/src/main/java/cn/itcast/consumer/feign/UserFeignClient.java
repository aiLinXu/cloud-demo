package cn.itcast.consumer.feign;

import cn.itcast.consumer.config.FeignConfig;
import cn.itcast.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xualin
 * @version v1.0
 * @date 2019/4/2 11:45
 * @description
 **/

@Component
@FeignClient(value = "eureka-service",configuration = FeignConfig.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User queryById(@PathVariable("id") Long id);
}
