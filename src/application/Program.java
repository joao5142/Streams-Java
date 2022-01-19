package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import entities.Product;

public class Program {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "//src//in.txt";

		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

			String line = bf.readLine();
			List<Product> list = new ArrayList<Product>();
			while (line != null) {
				String arr[] = line.split(",");
				list.add(new Product(arr[0], Double.parseDouble(arr[1])));
				line = bf.readLine();
			}
			list.forEach(System.out::println);
			System.out.println("\n");
			
			double media = list.stream().map(p -> p.getPrice()).reduce(0.0, (x, y) -> x + y) / list.size();
			System.out.println("Média dos produtos é : " + String.format("%.2f", media));
			System.out.println("\n");
			
			Comparator<String> comp= (s1,s2)->s1.toUpperCase().compareTo(s2.toUpperCase()); 
			List<String> filtredProducts = list.stream().filter(p -> p.getPrice() < media).map(p -> p.getName())
					.sorted(comp.reversed()).toList();

			filtredProducts.forEach(System.out::println);

		} catch (Exception e) {

		}
	}
}
