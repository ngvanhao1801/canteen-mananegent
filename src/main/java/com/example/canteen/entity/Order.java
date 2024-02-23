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
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_id",nullable = false)
	private int userId;

	@Column(name = "status",nullable = false)
	private String status;

	@Column(name = "shipping_address",nullable = false)
	private String shippingAddress;

	@Column(name = "total_price",nullable = false)
	private double totalPrice;

}
