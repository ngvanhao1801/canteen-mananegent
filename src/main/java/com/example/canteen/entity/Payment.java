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
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "order_id",nullable = false)
	private int orderId;

	@Column(name = "payment_date",nullable = false)
	private Date paymentDate;

	@Column(name = "total_price",nullable = false)
	private double totalPrice;

	@Column(name = "payment_method",nullable = false)
	private String paymentMethod;

	@Column(name = "status",nullable = false)
	private String status;

}
