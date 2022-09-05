package fruit;

import java.math.BigDecimal;

public class Apple extends Goods implements Fruit {
	
	public Apple() {
		super();
	}

	@Override
	public void discount(BigDecimal discountRate) {
		this.setPrice(this.getPrice().multiply(discountRate));
	}
	
}
