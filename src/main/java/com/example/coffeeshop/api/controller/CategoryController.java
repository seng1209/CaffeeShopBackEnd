package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.CategoryService;
import com.example.coffeeshop.api.web.category.CategoryDto;
import com.example.coffeeshop.api.web.category.CreateCategoryDto;
import com.example.coffeeshop.api.web.category.UpdateCategoryDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewCategory(@RequestBody @Valid CreateCategoryDto createCategoryDto){
        categoryService.createNewCategory(createCategoryDto);
    }

    @GetMapping
    public List<CategoryDto> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{name}")
    public CategoryDto findByName(@PathVariable String name){
        return categoryService.findByName(name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{name}")
    public void updateCategory(@PathVariable String name, @RequestBody UpdateCategoryDto updateCategoryDto){
        categoryService.updateCategory(name, updateCategoryDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void deleteCategoryByName(@PathVariable String name){
        categoryService.deleteCategoryByName(name);
    }

}
