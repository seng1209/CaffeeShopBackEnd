package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.ItemService;
import com.example.coffeeshop.api.web.item.CreateItemDto;
import com.example.coffeeshop.api.web.item.ItemDto;
import com.example.coffeeshop.api.web.item.UpdateItemDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/items")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewItem(@RequestBody @Valid CreateItemDto createItemDto){
        itemService.createNewItem(createItemDto);
    }

    @GetMapping
    public List<ItemDto> findAll(){
        return itemService.findAll();
    }

    @GetMapping("/{name}")
    public ItemDto findItemByName(@PathVariable String name){
        return itemService.findItemByName(name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{name}")
    public void updateItemByName(@PathVariable String name, @RequestBody @Valid UpdateItemDto updateItemDto){
        itemService.updateItemByName(name, updateItemDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void deleteItemByName(@PathVariable String name){
        itemService.deleteItemByName(name);
    }

    @GetMapping("/search")
    public ItemDto searchItemByName(@RequestParam(required = false, defaultValue = "") String name){
        return itemService.searchItemByName(name);
    }

    @GetMapping("/item_id/{id}")
    public ItemDto findById(@PathVariable Integer id){
        return itemService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<ItemDto> findAllByName(@PathVariable String name){
        return itemService.findAllByName(name);
    }

}
