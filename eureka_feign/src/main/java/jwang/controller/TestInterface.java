package jwang.controller;
/**
 * 远程服务调用类，name与服务名相同
 */
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name= "eureka-client")
public interface TestInterface {
	@GetMapping(value = "/get")
    String get();
}
