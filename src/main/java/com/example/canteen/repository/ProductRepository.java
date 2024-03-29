package com.example.canteen.repository;

import com.example.canteen.dto.ProductDto;
import com.example.canteen.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

  void save(ProductDto productDto);

  Product findById(int id);

  Product getProductById(int id);

}
