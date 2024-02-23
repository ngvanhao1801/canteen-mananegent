package com.example.canteen.service;

import com.example.canteen.dto.ProductDto;
import com.example.canteen.entity.Product;
import com.example.canteen.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getListProduct() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		return productRepository.findById(id);
	}

	public void save(ProductDto productDto) {
		productRepository.save(productDto);
	}
}
