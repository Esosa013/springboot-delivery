package com.example.delivery.controller;

import com.example.delivery.entity.Item;
import com.example.delivery.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // CRUD endpoints
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/code/{code}")
    public Item getItemByCode(@PathVariable String code) {
        return itemService.getItemByCode(code);
    }

    // =================== NEW: Assign / Remove Items from Vehicles ===================
    @PostMapping("/{itemId}/assign/{vehicleId}")
    public Item assignItemToVehicle(@PathVariable Long itemId, @PathVariable Long vehicleId) {
        itemService.assignItemToVehicle(itemId, vehicleId);
        return itemService.getItemById(itemId);
    }

    @PostMapping("/{itemId}/remove")
    public Item removeItemFromVehicle(@PathVariable Long itemId) {
        itemService.removeItemFromVehicle(itemId);
        return itemService.getItemById(itemId);
    }
}
