package springboot.microservices.catalogservice.web.controllers;

import lombok.extern.slf4j.Slf4j;
import springboot.microservices.catalogservice.entities.Product;
import springboot.microservices.catalogservice.exceptions.ProductNotFoundException;
import springboot.microservices.catalogservice.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {
 
    private final ProductService productService;
 
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
 
    @GetMapping("")
    public List<Product> allProducts() {
        return productService.findAllProducts();
    }
 
    @GetMapping("/{code}")
    public Product productByCode(@PathVariable String code) {
        return productService.findProductByCode(code).orElseThrow(() -> new ProductNotFoundException("Product with code ["+code+"] doesn't exist"));
    }
}