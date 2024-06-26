package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Item;
import com.example.coffeeshop.api.web.item.CreateItemDto;
import com.example.coffeeshop.api.web.item.ItemDto;
import com.example.coffeeshop.api.web.item.UpdateItemDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    // create item
    @Mapping(source = "categoryId", target = "category.id")
    Item formItemDto(CreateItemDto createItemDto);

    // update item
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void formUpdateItemDto(@MappingTarget Item item, UpdateItemDto updateItemDto);

    // select item
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "category")
    ItemDto toItemDto(Item item);

    // select all items
    List<ItemDto> toItemDtoList(List<Item> items);

}
