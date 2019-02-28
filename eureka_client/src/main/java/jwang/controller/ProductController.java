package jwang.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jwang.entity.Product;
import jwang.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	//集群情况下，用于订单服务查看到底调用的是哪个商品微服务节点
    @Value("${server.port}")
    private String port;
    @Autowired
    private ProductService productService;
    //获取所有商品列表
    @RequestMapping(value="list",produces = {"application/json;charset=UTF-8"})
    public Object list(){
        return productService.listProduct();
    }
  //根据id查找商品详情
    @RequestMapping(value="find",produces = {"application/json;charset=UTF-8"})
    public Object findById(int id){
        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName( result.getName() + " data from port="+port );
        return result;
    }
}
