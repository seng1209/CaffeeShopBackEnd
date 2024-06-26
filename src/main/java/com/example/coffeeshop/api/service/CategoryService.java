package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.category.CategoryDto;
import com.example.coffeeshop.api.web.category.CreateCategoryDto;
import com.example.coffeeshop.api.web.category.UpdateCategoryDto;

import java.util.List;

public interface CategoryService {

    // create category
    void createNewCategory(CreateCategoryDto createCategoryDto);

    // update category by name
    void updateCategory(String name, UpdateCategoryDto updateCategoryDto);

    // delete category by name
    void deleteCategoryByName(String name);

    // select category
    CategoryDto findByName(String name);

    // select categories
    List<CategoryDto> findAll();

}
