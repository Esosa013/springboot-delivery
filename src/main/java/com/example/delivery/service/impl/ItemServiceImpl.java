package com.example.delivery.service.impl;

import com.example.delivery.entity.Item;
import com.example.delivery.entity.Vehicle;
import com.example.delivery.repository.ItemRepository;
import com.example.delivery.repository.VehicleRepository;
import com.example.delivery.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final VehicleRepository vehicleRepository;

    public ItemServiceImpl(ItemRepository itemRepository, VehicleRepository vehicleRepository) {
        this.itemRepository = itemRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
public void assignItemToVehicle(Long itemId, Long vehicleId) {
    Item item = getItemById(itemId);
    Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow();
    item.setVehicle(vehicle);
    itemRepository.save(item);
}

@Override
public void removeItemFromVehicle(Long itemId) {
    Item item = getItemById(itemId);
    item.setVehicle(null);
    itemRepository.save(item);
}


    @Override
    public Item updateItem(Long id, Item updatedItem) {
        Item item = itemRepository.findById(id).orElseThrow();

        item.setName(updatedItem.getName());
        item.setWeight(updatedItem.getWeight());
        item.setCode(updatedItem.getCode());

        if (updatedItem.getVehicle() != null) {
            item.setVehicle(updatedItem.getVehicle());
        }

        return itemRepository.save(item);
    }


    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item getItemByCode(String code) {
        return itemRepository.findByCode(code);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
}
}
