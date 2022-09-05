package fruit.application;

import fruit.factory.FruitFactory;
import fruit.biz.Apple;
import fruit.service.serviceimpl.Customer;
import fruit.service.serviceimpl.ProxyShoppingCart;
import fruit.vo.Goods;
import fruit.biz.Mango;
import fruit.biz.Strawberry;
import fruit.service.ShoppingCartService;
import fruit.vo.Supermarket;

import java.math.BigDecimal;
import java.util.List;

public class Demo {
	
	public static void main(String[] args) throws Exception {
		Supermarket supermarket = new Supermarket();
		List<Goods> goodsList = supermarket.getGoodsList();

		FruitFactory factory = new FruitFactory();
		
		Apple apple =  factory.getFruit(Apple.class);
		apple.setPrice(new BigDecimal("8"));
		goodsList.add(apple);
		
		Strawberry strawberry = factory.getFruit(Strawberry.class);
		strawberry.setPrice(new BigDecimal("13"));
		goodsList.add(strawberry);
		
		Mango mango = factory.getFruit(Mango.class);
		mango.setPrice(new BigDecimal("20"));
		
		System.out.println("第1题---------------------------------------------------");
		Customer customerA = new Customer("A");
		ShoppingCartService shoppingCartA = new ProxyShoppingCart(supermarket, customerA);
		shoppingCartA.add(apple, 3);
		shoppingCartA.add(strawberry, 4);
		System.out.println("顾客"+customerA.getName()+"合计需支付:" + supermarket.calculate(customerA.getShoppingCart()) + "元\n");
		
		System.out.println("第2题---------------------------------------------------");
		
		goodsList.add(mango);
		
		Customer customerB = new Customer("B");
		ShoppingCartService shoppingCartB = new ProxyShoppingCart(supermarket, customerB);
		shoppingCartB.add(apple, 3);
		shoppingCartB.add(strawberry, 4);
		shoppingCartB.add(mango, 5);
		
		System.out.println("顾客"+customerB.getName()+"合计需支付:"+ supermarket.calculate(customerB.getShoppingCart()) + "元\n");
		
		System.out.println("第3题---------------------------------------------------");
		Customer customerC = new Customer("C");
		ShoppingCartService shoppingCartC = new ProxyShoppingCart(supermarket, customerC);
		apple.discount(new BigDecimal("0.8"));
		shoppingCartC.add(apple, 3);
		shoppingCartC.add(strawberry, 4);
		shoppingCartC.add(mango, 5);
		System.out.println("顾客"+customerC.getName()+"合计需支付:"+ supermarket.calculate(customerC.getShoppingCart()) + "元\n");
		
		System.out.println("第4题---------------------------------------------------");
		Customer customerD = new Customer("D");
		//设置满减
		supermarket.setSatisfy(new BigDecimal("100"));
		supermarket.setReduce(new BigDecimal("10"));
		ShoppingCartService shoppingCartD = new ProxyShoppingCart(supermarket, customerD);
		
		shoppingCartD.add(apple, 3);
		shoppingCartD.add(strawberry, 4);
		shoppingCartD.add(mango, 5);
		System.out.println("顾客"+customerD.getName()+"合计需支付:" + supermarket.calculate(customerC.getShoppingCart()) + "元\n");
	}

}
