package fruit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Supermarket {
	//满
	private BigDecimal satisfy;
	//减
	private BigDecimal reduce;
	
	private List<Goods> goodsList = new ArrayList<Goods>();
	
	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public BigDecimal getSatisfy() {
		return satisfy;
	}

	public void setSatisfy(BigDecimal satisfy) {
		this.satisfy = satisfy;
	}

	public BigDecimal getReduce() {
		return reduce;
	}

	public void setReduce(BigDecimal reduce) {
		this.reduce = reduce;
	}

	public BigDecimal calculate(Map<Goods, Integer> goodsMap) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		for(Goods goods : goodsMap.keySet()) {
			BigDecimal singlePrice = goods.getPrice().multiply(new BigDecimal(goodsMap.get(goods))).setScale(2,BigDecimal.ROUND_DOWN);
			totalPrice = totalPrice.add(singlePrice);
		}
		//满减
		if(this.satisfy != null && this.reduce != null) {
			int reduceCount = totalPrice.divide(this.satisfy).setScale(0, BigDecimal.ROUND_DOWN).intValue();
			totalPrice = totalPrice.subtract(this.reduce.multiply(new BigDecimal(Integer.toString(reduceCount)))) ;
		}
		return totalPrice;
	}
	
	
	
}
