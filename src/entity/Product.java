package entity;


public class Product {

	private String name;
	private Double price;
	
	public Product() {
	}
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
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
	
	// Static precisa do produto especifico no parâmetro
	public static boolean staticProductPredicate(Product x) {
		return x.getPrice() >= 100.0;
	}
	
	// Não estático é pelo objeto
	public boolean nonstaticProductPredicate() {
		return price >= 100.0;
	}

	@Override
	public String toString() {
		return "Name= " + name + ", Price= " + price;
	}
}