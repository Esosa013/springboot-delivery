package com.example.delivery.controller;

import com.example.delivery.entity.Vehicle;
import com.example.delivery.entity.Item;
import com.example.delivery.service.VehicleService;
import com.example.delivery.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final VehicleService vehicleService;
    private final ItemService itemService;

    public WebController(VehicleService vehicleService, ItemService itemService) {
        this.vehicleService = vehicleService;
        this.itemService = itemService;
    }

    // =================== HOME PAGE ===================
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // =================== VEHICLE PAGES ===================
    @GetMapping("/vehicles")
    public String vehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "vehicles";
    }

    @GetMapping("/vehicles/create")
    public String newVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle-form";
    }

    @GetMapping("/vehicles/edit/{id}")
    public String editVehicleForm(@PathVariable Long id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "vehicle-form";
    }

    @PostMapping("/vehicles/save")
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {
        if (vehicle.getId() == null) {
            vehicleService.createVehicle(vehicle);
        } else {
            vehicleService.updateVehicle(vehicle.getId(), vehicle);
        }
        return "redirect:/vehicles";
    }

    @GetMapping("/vehicles/delete/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }

    // =================== ITEM PAGES ===================
    @GetMapping("/items")
    public String items(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "items";
    }

    @GetMapping("/items/create")
    public String newItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "item-form";
    }

    @GetMapping("/items/edit/{id}")
    public String editItemForm(@PathVariable Long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "item-form";
    }

    @PostMapping("/items/save")
    public String saveItem(@ModelAttribute Item item) {
        if (item.getId() == null) {
            itemService.createItem(item);
        } else {
            itemService.updateItem(item.getId(), item);
        }
        return "redirect:/items";
    }

    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }

    // =================== VEHICLE ITEM MANAGEMENT ===================
    @GetMapping("/vehicles/{vehicleId}/items")
    public String manageVehicleItems(@PathVariable Long vehicleId, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("vehicleItems", vehicle.getItems());
        model.addAttribute("allItems", itemService.getAllItems());
        return "vehicle-items";
    }

    @PostMapping("/vehicles/{vehicleId}/items/add")
    public String addItemToVehicle(
            @PathVariable Long vehicleId,
            @RequestParam Long itemId) {

        itemService.assignItemToVehicle(itemId, vehicleId);
        return "redirect:/vehicles/" + vehicleId + "/items";
    }

    @GetMapping("/vehicles/{vehicleId}/items/remove/{itemId}")
    public String removeItemFromVehicle(
            @PathVariable Long vehicleId,
            @PathVariable Long itemId) {

        itemService.removeItemFromVehicle(itemId);
        return "redirect:/vehicles/" + vehicleId + "/items";
    }
}
