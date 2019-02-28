package jwang.service;

import jwang.entity.ProductOrder;

/**
 * 订单业务类
 * @author wangjing139
 *
 */
public interface ProductOrderService {
	//下单接口
    ProductOrder save(int userId, int productId);
}
