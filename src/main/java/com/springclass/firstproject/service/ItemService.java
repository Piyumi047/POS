package com.springclass.firstproject.service;

import com.springclass.firstproject.dto.ItemDTO;
import com.springclass.firstproject.dto.request.IteamUpdateDTO;
import com.springclass.firstproject.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemDTO itemDTO);

    List<ItemGetResponseDTO> getItembyQtyandStatus(double qty, boolean status);

    String deleteCustomer(String itemId);

    ItemDTO updateItem(IteamUpdateDTO iteamUpdateDTO);
}
