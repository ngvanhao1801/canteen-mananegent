package com.example.canteen.controller.product;

import com.example.canteen.entity.Product;
import com.example.canteen.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

	private final ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/products")
	public String getAllProducts(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "product_list";
	}

	@GetMapping("/product/{id}")
	public String getProductById(@PathVariable("id") int id, Model model) {
		Product product = productRepository.findById(id);
		model.addAttribute("product", product);
		return "productDetail";
	}

	@GetMapping("/product/add")
	public String showAddProductForm() {
		return "addProduct";
	}

	@PostMapping("/product/add")
	public String addProduct(@RequestParam("name") String name,
	                         @RequestParam("description") String description,
	                         @RequestParam("price") double price,
	                         @RequestParam("quantity") int quantity,
	                         @RequestParam("image") MultipartFile imageFile) throws IOException {
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setImage(imageFile.getBytes());
		productRepository.save(product);
		return "redirect:/products";
	}

	@GetMapping("/product/edit/{id}")
	public String showEditProductForm(@PathVariable("id") int id, Model model) {
		Product product = productRepository.findById(id);
		model.addAttribute("product", product);
		return "editProduct";
	}

	@PostMapping("/product/edit/{id}")
	public String editProduct(@PathVariable("id") int id,
	                          @RequestParam("name") String name,
	                          @RequestParam("description") String description,
	                          @RequestParam("price") double price,
	                          @RequestParam("quantity") int quantity,
	                          @RequestParam("image") MultipartFile imageFile) throws IOException {
		Product product = productRepository.findById(id);
		if (product != null) {
			product.setName(name);
			product.setDescription(description);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setImage(imageFile.getBytes());
			productRepository.save(product);
		}
		return "redirect:/products";
	}

	@PostMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		productRepository.deleteById(id);
		return "redirect:/products";
	}

}
