package com.example.delivery.repository;

import com.example.delivery.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByCode(String code);
}
