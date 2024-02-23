package com.example.canteen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "images",nullable = false)
	@Lob
	private byte[] images;

	@Column(name = "name",nullable = false)
	private String name;

	@Column(name = "quantity",nullable = false)
	private int quantity;

	@Column(name = "price",nullable = false)
	private double price;

	@Column(name = "total",nullable = false)
	private int total;

}
