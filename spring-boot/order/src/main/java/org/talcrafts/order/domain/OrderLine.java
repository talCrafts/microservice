package com.ewolff.microservice.order.logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import java.util.Objects;

@Entity
public class OrderLine {

	@Column(name = "F_COUNT")
	private int count;

	private long itemId;

	@Id
	@GeneratedValue
	private long id;

	public void setCount(int count) {
		this.count = count;
	}

	public void setItemId(long item) {
		this.itemId = item;
	}

	public OrderLine() {
	}

	public OrderLine(int count, long item) {
		this.count = count;
		this.itemId = item;
	}

	public int getCount() {
		return count;
	}

	public long getItemId() {
		return itemId;
	}

	@Override
	public String toString() {
		return Objects.toString(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id,itemId);

	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this, obj);
	}

}
