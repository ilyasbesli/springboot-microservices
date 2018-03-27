package springboot.microservices.catalogservice.services;


import lombok.extern.slf4j.Slf4j;
import springboot.microservices.catalogservice.entities.Product;
import springboot.microservices.catalogservice.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
 
@Service
@Transactional
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
 
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
 
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
 
    public Optional<Product> findProductByCode(String code) {
        return productRepository.findByCode(code);
    }
}