package jwang.Fallback;

import jwang.interfac.ProductClient;

public class ProductClientFallback implements ProductClient {

	@Override
	public String findById(int id) {
		// TODO Auto-generated method stub
		System.out.println("ProductClientFallback中的降级方法++++++++++++++++");
		//这对gai该接口进行一些逻辑降级处理........
		return null;
	}

}
