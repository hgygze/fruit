package fruit.service.serviceimpl;

import fruit.vo.Goods;
import fruit.service.ShoppingCartService;

import java.util.HashMap;
import java.util.Map;

public class Customer implements ShoppingCartService {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Map<Goods, Integer> shoppingCart = new HashMap<Goods, Integer>();

	public Customer(String name) {
		this.name = name;
	}
	
	@Override
	public void add( Goods goods, Integer number) throws Exception {
		this.shoppingCart.put(goods, number);
	}

	public Map<Goods, Integer> getShoppingCart() {
		return shoppingCart;
	}

}
