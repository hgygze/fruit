package fruit.biz;

import fruit.service.FruitService;
import fruit.vo.Goods;

import java.math.BigDecimal;

public class Apple extends Goods implements FruitService {
	
	public Apple() {
		super();
	}

	@Override
	public void discount(BigDecimal discountRate) {
		this.setPrice(this.getPrice().multiply(discountRate));
	}
	
}
