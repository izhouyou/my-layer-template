package info.jiatu.jtlsp.web.controller;

import info.jiatu.jtlsp.rpc.service.DemoRpcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author izhou
 * @path info.jiatu.jtlsp.template.controller
 * @methodName DemoRpcController
 * @description 测试Rpc接口
 * @dateTime 2022/10/23 23:53
 * @editNote
 */
@RestController
@RequestMapping("/rpc")
public class DemoRpcController {

    @Resource
    private DemoRpcService demoRpcService;

    @GetMapping("queryBaiDu")
    public String queryBaiDu() {
        return demoRpcService.queryBaiDu();
    }

}
