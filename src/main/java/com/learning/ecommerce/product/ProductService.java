package com.learning.ecommerce.product;

import com.learning.ecommerce.category.Category;
import com.learning.ecommerce.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> listProduct(){
        return productRepository.findAll();
    }
}
