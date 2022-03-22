package com.learning.ecommerce.category;

import com.learning.ecommerce.category.Category;
import com.learning.ecommerce.category.CategoryRepository;
import com.learning.ecommerce.product.Product;
import com.learning.ecommerce.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Category> listCategories(){
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Optional<Category> findByIdCategory(Long categoryId){
        return categoryRepository.findById(categoryId);
    }

    public Category findByCategoryName(String name){
        return categoryRepository.findByCategoryName(name);
    }

    public Category updateCategory(Long categoryId, Category category){
        Category cat = categoryRepository.findById(categoryId).get();
        cat.setCategoryName(category.getCategoryName());
        cat.setDescription(category.getDescription());
        cat.setImageURL(category.getImageURL());
        return categoryRepository.save(cat);
    }

    public Category addProductToCategory(Long categoryId, Long productId){
        Category category = categoryRepository.findById(categoryId).get();
        Product product = productRepository.findById(productId).get();
        List<Product> products = category.getProducts();
        products.add(product);
        category.setProducts(products);
        return categoryRepository.save(category);
    }
}
