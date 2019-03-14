package jwang.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import jwang.service.ProductOrderService;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
	@Autowired
    private ProductOrderService productOrderService;
    
    @RequestMapping("save")
    //当调用微服务出现异常会降级到saveOrderFail方法中
    //fallbackMethod = "saveOrderFail"中的saveOrderFail方法中的参数类型，个数，顺序要和save一模一样，否则会报找不到saveOrderFail方法。
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id")int userId, @RequestParam("product_id") int productId){

    	return productOrderService.save(userId, productId);
    }
    //注意，方法签名一定要要和api方法一致
    private Object saveOrderFail(int userId, int productId){

        System.out.println("controller中的降级方法");

        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "抢购人数太多，您被挤出来了，稍等重试");
        return msg;
    }
}
