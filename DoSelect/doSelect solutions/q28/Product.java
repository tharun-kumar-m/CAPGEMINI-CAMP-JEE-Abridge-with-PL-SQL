package q28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {
	private Integer id;
	private String name;
	private Double price;
	public Product(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product{id="+id+" name='" + name +"', price="+price+"}";
	}
	public static void main(String[] args) {
		Product pr5 = new Product(1, "Bruchotte", 5.0);
		Product pr6 = new Product(4, "Banana", 1305.0);
		Product pr7 = new Product(3, "Banana", 132.0);

		List<Product> pr= Arrays.asList(pr5, pr6, pr7);
		Implementation implementation=new Implementation();
		System.out.println(implementation.getProductName(pr));
		System.out.println(implementation.getSum(pr));
	}
}
class Implementation{
	public Map<String, List<Product>> getProductName(List<Product> products){
		Map<String, List<Product>> tempMap = new HashMap<String, List<Product>>();
		for(Product p:products) {
			List<Product> ProductList=new ArrayList<>();
			if(p.getPrice()>20.0) {
				if(!tempMap.containsKey(p.getName())) {
					ProductList.add(p);
					tempMap.put(p.getName(),ProductList);
				}
				else {
					List<Product> temp=new ArrayList<>();
					ProductList.add(p);
					temp=tempMap.get(p.getName());
					temp.addAll(ProductList);
					tempMap.put(p.getName(),temp) ;
				}
			}
		}
		return tempMap;
	}
	public Map<String, Double> getSum(List<Product> products){
		Map<String, Double> tempMap = new HashMap<String, Double>();
		for(Product p:products) {
			if(!tempMap.containsKey(p.getName())) {
				tempMap.put(p.getName(),p.getPrice());
			}
			else {
				double temp=tempMap.get(p.getName());
				temp+=p.getPrice();
				tempMap.put(p.getName(),temp);
			}
		}
		return tempMap;
	}
}
