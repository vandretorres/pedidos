package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	
	private Date moment;
	private OrderStatus status;
	private Client client;	
	private List<OrderItem> orderItem = new ArrayList<>();
	
	
	public Order() {
		
	}


	public Order(Date moment, OrderStatus status) {
		
		this.moment = moment;
		this.status = status;
	}


	public Date getMoment() {
		return moment;
	}


	public void setMoment(Date moment) {
		this.moment = moment;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public void addItem(OrderItem item) {
		
		orderItem.add(item);
		
	}
	
public void removeItem(OrderItem item) {
		
		orderItem.remove(item);
		
	}



@Override
public String toString() {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	StringBuilder sb = new StringBuilder();
	
	sb.append("ORDER SUMMMARY: \n");		
	sb.append("Order Moment: " + sdf.format(moment) +"\n");
	sb.append("Order Status: " + status +"\n" );
	sb.append("Client: " + client.getName() );
	sb.append(" ( " + sdf.format(client.getBirthDate()) + ") - " + client.getEmail() +"\n" );
	sb.append("Order items: \n");
	double sum = 0;
	for (OrderItem oi : orderItem) {
		
		sb.append(oi.getProduct().getName() + ", " + oi.getPrice() + ", Quantity: " + oi.getQuantity() + ", Subtotal: $" + oi.subTotal() +"\n");
		sum += oi.subTotal();
	}
	sb.append("Total price: $" + sum);
	return sb.toString();
  
}


	
	
	
	
	
	
}
