package com.example.shop.controller;


import com.example.shop.model.Category;
import com.example.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model){
        model.addAttribute("categories",categoryService.gelAllCategories());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("category",new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable Long id){
        categoryService.removeCategoryById(id);
        return  "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable Long id,Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()){
            model.addAttribute("category",category.get());
            return "categoriesAdd";
        }else
            return  "404";
    }

}
