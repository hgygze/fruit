package fruit.biz;

import fruit.service.FruitService;
import fruit.vo.Goods;

import java.math.BigDecimal;

public class Mango extends Goods implements FruitService {
	
	public Mango() {
		super();
	}
	
	@Override
	public void discount(BigDecimal discountRate) {
		
	}
	
}
