package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		Client client = new Client(name, email, birthDate);		
		
		
		System.out.println("Enter order data:");
		
		System.out.print("Status: ");
		String status = sc.nextLine();	
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status));
		order.setClient(client);
			
		
		
		System.out.print("How many items to this order: ");
		int numItem = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= numItem; i++) {
			
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product Name: ");
			String product = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			Product prod = new Product(product, price);				
			OrderItem oi = new OrderItem(prod, quantity, price);
			order.addItem(oi);
			
		}
		System.out.println();
		System.out.println(order);
	
		
		
		sc.close();
	}

}
