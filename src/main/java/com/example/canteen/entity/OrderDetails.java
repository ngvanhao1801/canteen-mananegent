package com.example.canteen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "order_id",nullable = false)
	private int orderId;

	@Column(name = "product_id",nullable = false)
	private int productId;

	@Column(name = "user_id",nullable = false)
	private int userId;

	@Column(name = "order_date",nullable = false)
	private Date orderDate;

	@Column(name = "price",nullable = false)
	private double price;

	@Column(name = "quantity",nullable = false)
	private int quantity;

}
