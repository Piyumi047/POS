package com.springclass.firstproject.util.mappers;

import com.springclass.firstproject.dto.response.ItemGetResponseDTO;
import com.springclass.firstproject.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToResponseDTOList(List<Item> items);
}
