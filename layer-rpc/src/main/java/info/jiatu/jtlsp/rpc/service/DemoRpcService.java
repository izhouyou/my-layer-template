package info.jiatu.jtlsp.rpc.service;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import retrofit2.http.GET;

/**
 * @author izhou
 * @path info.jiatu.jtlsp.template.rpc.service
 * @methodName DemoRpcService
 * @description 测试接口
 * @dateTime 2022/10/23 23:51
 * @editNote
 */
@RetrofitClient(baseUrl = "https://www.baidu.com")
public interface DemoRpcService {

    @GET("/")
    String queryBaiDu();
}
