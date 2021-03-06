package entities;

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
	
	public static String staticUpperCaseFunc(Product p) {
		return p.getName().toUpperCase();
	}
	 
	public String nonStaticUpperCaseFunc() {
		return this.getName().toUpperCase();
	}
			
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [" + name + ", " + price + "]";
	}
	
	

}
