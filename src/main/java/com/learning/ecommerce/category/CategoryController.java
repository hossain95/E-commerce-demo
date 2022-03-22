package com.learning.ecommerce.category;

import com.learning.ecommerce.category.Category;
import com.learning.ecommerce.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("")
    public List<Category>listCategories(){
        return categoryService.listCategories();
    }

    @GetMapping("/{categoryId}")
    public Optional<Category> findByIdCategory(@PathVariable("categoryId") Long categoryId){
        return categoryService.findByIdCategory(categoryId);
    }

    @GetMapping("/name")
    public Category findByCategoryName(@RequestParam(name="categoryName") String categoryName){
        return categoryService.findByCategoryName(categoryName);
    }

    @PutMapping("/update/{categoryId}")
    public Category updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody Category category){
        return categoryService.updateCategory(categoryId, category);
    }

    @PutMapping("/add-product")
    public Category addProductToCategory(@RequestParam(name = "categoryId") Long categoryId, @RequestParam(name = "productId") Long productId){
        return categoryService.addProductToCategory(categoryId, productId);
    }
}
