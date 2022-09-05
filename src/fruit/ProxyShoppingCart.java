package fruit;

public class ProxyShoppingCart implements ShoppingCart{
	
	private Supermarket supermarket;
	
	private Customer customer;
	
	public ProxyShoppingCart(Supermarket supermarket, Customer customer) {
		super();
		this.supermarket = supermarket;
		this.customer = customer;
	}



	@Override
	public void add(Goods goods, Integer number) throws Exception {
		if(!supermarket.getGoodsList().contains(goods)) {
			throw new Exception("超市中暂无"+ goods.getClass().getSimpleName() +"商品！");
		}
		
		if(number < 0) {
			throw new Exception("重量不可小于0！");
		}
		
		customer.add(goods, number);
	}

}
