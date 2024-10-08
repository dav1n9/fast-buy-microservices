package com.example.fastbuymicroservices.domain.item.service;

import com.example.fastbuymicroservices.domain.item.dto.CreateItemRequestDto;
import com.example.fastbuymicroservices.domain.item.dto.ItemResponseDto;
import com.example.fastbuymicroservices.domain.item.entity.Item;
import com.example.fastbuymicroservices.domain.item.repository.ItemRepository;
import com.example.fastbuymicroservices.global.exception.BusinessException;
import com.example.fastbuymicroservices.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponseDto save(CreateItemRequestDto request) {
        Item item = itemRepository.save(request.toEntity());
        return new ItemResponseDto(item);
    }

    public List<ItemResponseDto> findAll() {
        return itemRepository.findAll().stream().map(ItemResponseDto::new).toList();
    }

    public ItemResponseDto findById(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ITEM_NOT_FOUND));
        return new ItemResponseDto(item);
    }
}
