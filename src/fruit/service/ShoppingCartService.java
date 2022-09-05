package fruit.service;

import fruit.vo.Goods;

public interface ShoppingCartService {
	
	void add(Goods goods, Integer number) throws Exception;
}
