package com.project.entities.rcm;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	private String name;
	private String description;
	private float price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Categories category_data;
	private int category_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Suppliers supplier_data;
	private int supplier_id;
	
	
	public Suppliers getSupplier_data() {
		return supplier_data;
	}
	public void setSupplier_data(Suppliers supplier_data) {
		this.supplier_data = supplier_data;
	}
	public Categories getCategory_data() {
		return category_data;
	}
	public void setCategory_data(Categories category_data) {
		this.category_data = category_data;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (description != null ? "description=" + description + ", " : "") + "price=" + price + ", category_id="
				+ category_id + ", supplier_id=" + supplier_id + "]";
	}
	
	

}
