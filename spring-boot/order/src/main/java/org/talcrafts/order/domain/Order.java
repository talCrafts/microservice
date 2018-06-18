package com.ewolff.microservice.order.logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Objects;


@Entity
@Table(name = "ORDERTABLE")
class Order {

	@Id
	@GeneratedValue
	private long id;

	private long customerId;

	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLine> orderLine;

	public Order() {
		super();
		orderLine = new ArrayList<OrderLine>();
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public List<OrderLine> getOrderLine() {
		return orderLine;
	}

	public Order(long customerId) {
		super();
		this.customerId = customerId;
		this.orderLine = new ArrayList<OrderLine>();
	}

	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}

	public void addLine(int count, long itemId) {
		this.orderLine.add(new OrderLine(count, itemId));
	}

	public int getNumberOfLines() {
		return orderLine.size();
	}

	// public double totalPrice(CatalogClient itemClient) {
	// 	return orderLine.stream()
	// 			.map((ol) -> ol.getCount() * itemClient.price(ol.getItemId()))
	// 			.reduce(0.0, (d1, d2) -> d1 + d2);
	// }

	public void setCustomer(long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return Objects.toString(id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id,customerId);

	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Order){
			Order other=(Order) obj;
			return Objects.equals(this.id,other.id);
		}
		return false;
	}
}
