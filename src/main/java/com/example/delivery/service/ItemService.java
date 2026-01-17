package com.example.delivery.service;

import com.example.delivery.entity.Item;
import java.util.List;

public interface ItemService {
    Item getItemById(Long id);
    Item createItem(Item item);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
    Item getItemByCode(String code);
    List<Item> getAllItems();
    void assignItemToVehicle(Long itemId, Long vehicleId);
    void removeItemFromVehicle(Long itemId);

}
