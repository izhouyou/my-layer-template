package info.jiatu.jtlsp.web.controller;

import info.jiatu.jtlsp.web.util.RedisUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author izhouy
 * @title RedisController
 * @Decription
 * @CreateDate 2021/6/23 23:52
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisUtils redisUtils;

    @GetMapping("setValue")
    public String setValue(@RequestParam("key") String key, @RequestParam("value") String value){
        redisUtils.setStr(key, value);
        return "success";
    }

    @GetMapping("getValue")
    public String getValue(@RequestParam("key") String key){
        return redisUtils.getStr(key);
    }

    @GetMapping("uptValue")
    public String uptValue(@RequestParam("key") String key, @RequestParam("value") String value){
        redisUtils.setStr(key, value);
        return "success";
    }

    @GetMapping("getValue2")
    public String uptValue(@RequestParam("key") String key){
        redisUtils.getStr(key);
        return "success";
    }
}