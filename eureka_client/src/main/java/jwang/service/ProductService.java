package jwang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jwang.entity.Product;

public interface ProductService {
	//查找所有商品
    List<Product> listProduct();

    //根据商品ID查找商品
    Product findById(int id);
}
