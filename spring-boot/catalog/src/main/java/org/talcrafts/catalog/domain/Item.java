package org.talcrafts.catalog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private double price;

	public Item() {
		super();
		id = 0l;
	}

	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return Objects.toString(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id,name);

	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item){
			Item other=(Item)obj;
			return Objects.equals(id,other.id);
		}
		return false;
	}

}
