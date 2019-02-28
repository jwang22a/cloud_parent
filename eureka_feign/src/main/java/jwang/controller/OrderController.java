package jwang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwang.service.ProductOrderService;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
	@Autowired
    private ProductOrderService productOrderService;
    
    @RequestMapping("save")
    public Object save(@RequestParam("user_id")int userId, @RequestParam("product_id") int productId){

    return productOrderService.save(userId, productId);
    }
}
