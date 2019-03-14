package jwang.controller;
import org.springframework.cloud.netflix.feign.FeignClient;
/**
 * 商品服务客户端
 * name = "product-service"是服务端名称
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "eureka-client")
public interface ProductClient {
	//这样组合就相当于http://eureka-client/api/v1/product/find
    @GetMapping("/api/v1/product/find")
    String findById(@RequestParam(value = "id") int id);
}
