package com.example.fastbuymicroservices.domain.item.repository;

import com.example.fastbuymicroservices.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
