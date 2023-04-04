package com.springclass.firstproject.service;

import com.springclass.firstproject.dto.ItemDTO;
import com.springclass.firstproject.dto.pagenated.PagenatedResponaseItemDTO;
import com.springclass.firstproject.dto.request.IteamUpdateDTO;
import com.springclass.firstproject.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemDTO itemDTO);

    List<ItemGetResponseDTO> getItembyQtyandStatus(double qty, boolean status);

    String deleteCustomer(int itemId);

    ItemDTO updateItem(IteamUpdateDTO iteamUpdateDTO);

    PagenatedResponaseItemDTO getItemByStatusPagenated(boolean status, int page, int size);

    List<ItemGetResponseDTO> getItembyQtyandStatusByMapstruct(double qty, boolean status);
}
