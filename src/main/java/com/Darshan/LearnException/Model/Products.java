package com.Darshan.LearnException.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid;
	
	@NotBlank(message = "Enter Valid Name")
	private String name;
	
	@Min(10)
	private int price;
	
	@NotNull(message = "Enter Description")
	private String description;
	
	@NotBlank(message = "Enter Manufacturer Name")
	private String manufacturerName;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(long pid, String name, int price, String description, String manufacturerName) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.description = description;
		this.manufacturerName = manufacturerName;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	@Override
	public String toString() {
		return "Products [pid=" + pid + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", manufacturerName=" + manufacturerName + "]";
	}
	
	

	
}
