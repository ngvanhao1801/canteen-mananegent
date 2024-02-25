package com.example.canteen.controller.product;

import com.example.canteen.entity.Product;
import com.example.canteen.repository.ProductRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

  private final ProductRepository productRepository;


  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  private boolean isEdit = false;

  private String errorMessage = "";

  @GetMapping("/add_product")
  public String addProduct(Model model) {
    model.addAttribute("errorMessage", errorMessage);

    return "add_product";
  }

  @GetMapping("/products")
  public String getAllProducts(Model model) {
    List<Product> products = productRepository.findAll();
    model.addAttribute("products", products);
    return "product_list";
  }

  @GetMapping("/productImage")
  public ResponseEntity<byte[]> getProductImage(@RequestParam("id") int id) {
    Product product = productRepository.findById(id);
    byte[] imageData = product.getImage();

    return ResponseEntity.ok()
        .contentType(MediaType.IMAGE_PNG)
        .body(imageData);
  }

  @PostMapping("/save")
  public String saveProduct(@ModelAttribute Product product, Model model) {
    errorMessage = "";
    if (!isEdit && productRepository.existsById(product.getId())) {
      isEdit = false;
      errorMessage = "Đã tồn tại id = " + product.getId();
      model.addAttribute("product", product);
      return "redirect:/add_product";
    }

    productRepository.save(product);
    return "redirect:/products";
  }

  @RequestMapping("/editProduct/{id}")
  public String editLecturer(@PathVariable("id") int id, Model model) {
    Product product = productRepository.getProductById(id);
    model.addAttribute("product", product);

    isEdit = true;

    return "edit_product";
  }

  @RequestMapping("/deleteProduct/{id}")
  public String deleteProduct(@PathVariable("id") int id) {
    productRepository.deleteById(id);

    return "redirect:/products";
  }

//
//  @PostMapping("/product/edit/{id}")
//  public String editProduct(@PathVariable("id") int id,
//                            @RequestParam("name") String name,
//                            @RequestParam("description") String description,
//                            @RequestParam("price") double price,
//                            @RequestParam("quantity") int quantity,
//                            @RequestParam("image") MultipartFile imageFile) throws IOException {
//    Product product = productRepository.findById(id);
//    if (product != null) {
//      product.setName(name);
//      product.setDescription(description);
//      product.setPrice(price);
//      product.setQuantity(quantity);
//      product.setImage(imageFile.getBytes());
//      productRepository.save(product);
//    }
//    return "redirect:/products";
//  }

  //  @GetMapping("/product/{id}")
//  public String getProductById(@PathVariable("id") int id, Model model) {
//    Product product = productRepository.findById(id);
//    model.addAttribute("product", product);
//    return "productDetail";
//  }

//  @PostMapping("/save")
//  public String addProduct(@RequestParam("name") String name,
//                           @RequestParam("description") String description,
//                           @RequestParam("price") double price,
//                           @RequestParam("quantity") int quantity,
//                           @RequestParam("image") MultipartFile imageFile) throws IOException {
//    Product product = new Product();
//    product.setName(name);
//    product.setDescription(description);
//    product.setPrice(price);
//    product.setQuantity(quantity);
//    product.setImage(imageFile.getBytes());
//    productRepository.save(product);
//    return "redirect:/products";
//  }

}