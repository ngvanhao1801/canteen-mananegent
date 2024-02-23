package com.example.canteen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private String name;

	private byte[] image;

	private String description;

	private double price;

	private int quantity;

}
