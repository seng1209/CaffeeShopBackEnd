package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Category;
import com.example.coffeeshop.api.web.category.CategoryDto;
import com.example.coffeeshop.api.web.category.CreateCategoryDto;
import com.example.coffeeshop.api.web.category.UpdateCategoryDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // create category

    /**
     * mapping to create category. map by "CategoryDto" to "Category"
     * @param createCategoryDto
     * @return
     */
    Category formCategoryDto(CreateCategoryDto createCategoryDto);

    // update category

    /**
     * mapping to update category. map by "Category" with "UpdateCategoryDto"
     * @param category
     * @param updateCategoryDto
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void formUpdateCategoryDto(@MappingTarget Category category, UpdateCategoryDto updateCategoryDto);

    // select category

    /**
     * mapping to select category. "Category" to "CategoryDto"
     * @param category
     * @return
     */
    CategoryDto toCategoryDto(Category category);

    // select categories

    /**
     * mapping to select categories. list of "Category" to list of "CategoryDto"
     * @param categories
     * @return
     */
    List<CategoryDto> toCategoryDtoList(List<Category> categories);

}
