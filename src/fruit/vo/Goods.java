package fruit.vo;

import java.math.BigDecimal;


public abstract class Goods {

	private BigDecimal price;
	
	public Goods() {
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


}
