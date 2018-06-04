package com.niit.ToysBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component

public class Product {
	@Id
	private String productId;
	private String productName;
	private String productDescription;
	private int Quantity;
	private double Price;

	private String ImageName;
	@Transient
	private MultipartFile pimg;

	public MultipartFile getPimg() {
		return pimg;
	}

	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}

	public String getImageName() {
		return ImageName;
	}

	public void setImageName(String imageName) {
		ImageName = imageName;
	}

	public Product() {
		this.productId = "PRO" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	@ManyToOne
	@JoinColumn(name = "supplierId")
	private Supplier supplier;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductId() {
		return productId;

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
