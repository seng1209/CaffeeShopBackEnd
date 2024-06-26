package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Category;
import com.example.coffeeshop.api.entities.Item;
import com.example.coffeeshop.api.mapper.ItemMapper;
import com.example.coffeeshop.api.repository.ItemRepository;
import com.example.coffeeshop.api.web.item.CreateItemDto;
import com.example.coffeeshop.api.web.item.ItemDto;
import com.example.coffeeshop.api.web.item.UpdateItemDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImplement implements ItemService{

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    @Override
    public void createNewItem(CreateItemDto createItemDto) {
        Item item = itemMapper.formItemDto(createItemDto);
        itemRepository.save(item);
    }

    @Override
    public void updateItemByName(String name, UpdateItemDto updateItemDto) {
        if (itemRepository.existsByName(name)){
            Item item = itemRepository.findByName(name).orElseThrow();
            itemMapper.formUpdateItemDto(item, updateItemDto);

            if (updateItemDto.categoryId() != null){
                Category newCategory = new Category();
                newCategory.setId(updateItemDto.categoryId());
                item.setCategory(newCategory);
            }

            itemRepository.save(item);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Item name : %s is not found!....", name));
    }

    @Override
    public void deleteItemByName(String name) {
        Item item = itemRepository.findByName(name).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Item name : %s is not found!....", name))
        );
        itemRepository.delete(item);
    }

    @Override
    public ItemDto findItemByName(String name) {
        Item item = itemRepository.findByName(name).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Item name : %s is not found!....", name))
        );
        return itemMapper.toItemDto(item);
    }

    @Override
    public List<ItemDto> findAll() {
        List<Item> items = itemRepository.findAll();
        return itemMapper.toItemDtoList(items);
    }

    @Override
    public ItemDto searchItemByName(String name) {
        Item item = itemRepository.findByName(name).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Item name : %s is not found!....", name))
        );
        return itemMapper.toItemDto(item);
    }
}
