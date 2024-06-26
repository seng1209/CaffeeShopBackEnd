package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Item;
import com.example.coffeeshop.api.web.item.CreateItemDto;
import com.example.coffeeshop.api.web.item.ItemDto;
import com.example.coffeeshop.api.web.item.UpdateItemDto;

import java.util.List;

public interface ItemService {

    // create item
    void createNewItem(CreateItemDto createItemDto);

    // update item by name
    void updateItemByName(String name, UpdateItemDto updateItemDto);

    // delete item by name
    void deleteItemByName(String name);

    // select item by name
    ItemDto findItemByName(String name);

    // select all items
    List<ItemDto> findAll();

    // search items by name
    ItemDto searchItemByName(String name);

}
