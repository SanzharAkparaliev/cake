package com.example.shop.service;

import com.example.shop.model.Category;
import com.example.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
   @Autowired
   CategoryRepository categoryRepository;

   public List<Category> gelAllCategories(){
       return categoryRepository.findAll();
   }

   public void addCategory(Category category){
       categoryRepository.save(category);
   }

   public void removeCategoryById(Long id){
       categoryRepository.deleteById(id);
   }

    public Optional<Category> getCategoryById(Long id) {
    return categoryRepository.findById(id);
   }
}
