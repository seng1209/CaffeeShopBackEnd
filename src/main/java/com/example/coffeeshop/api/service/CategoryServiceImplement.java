package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Category;
import com.example.coffeeshop.api.mapper.CategoryMapper;
import com.example.coffeeshop.api.repository.CategoryRepository;
import com.example.coffeeshop.api.web.category.CategoryDto;
import com.example.coffeeshop.api.web.category.CreateCategoryDto;
import com.example.coffeeshop.api.web.category.UpdateCategoryDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImplement implements CategoryService{

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public void createNewCategory(CreateCategoryDto createCategoryDto) {
        Category category = categoryMapper.formCategoryDto(createCategoryDto);
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(String name, UpdateCategoryDto updateCategoryDto) {
        if (categoryRepository.existsByName(name)){
            Category category = categoryRepository.findByName(name).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            String.format("Category name : %s not found!....", name))
            );
            categoryMapper.formUpdateCategoryDto(category, updateCategoryDto);
            categoryRepository.save(category);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Category name : %s not found!....", name));
    }

    @Override
    public void deleteCategoryByName(String name) {
        Category category = categoryRepository.findByName(name).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Category name : %s not found!....", name))
        );
        categoryRepository.delete(category);

    }

    @Override
    public CategoryDto findByName(String name) {
        Category category = categoryRepository.findByName(name).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Category name : %s not found!....", name))
        );
        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toCategoryDtoList(categories);
    }

    @Override
    public CategoryDto findById(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Category at ID : %s not found!", id))
        );
        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public List<CategoryDto> findAllByName(String name) {
        List<Category> categories = categoryRepository.findAllByName(name);
        return categoryMapper.toCategoryDtoList(categories);
    }
}
