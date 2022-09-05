package fruit.biz;

import fruit.service.FruitService;
import fruit.vo.Goods;

import java.math.BigDecimal;

public class Strawberry extends Goods implements FruitService {
	
	public Strawberry() {
		super();
	}
	
	@Override
	public void discount(BigDecimal discountRate) {
		
	}
	
}
