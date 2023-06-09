package com.springclass.firstproject.service.impl;

import com.springclass.firstproject.dto.ItemDTO;
import com.springclass.firstproject.dto.pagenated.PagenatedResponaseItemDTO;
import com.springclass.firstproject.dto.request.IteamUpdateDTO;
import com.springclass.firstproject.dto.response.ItemGetResponseDTO;
import com.springclass.firstproject.entity.Item;
import com.springclass.firstproject.repo.ItemRepo;
import com.springclass.firstproject.service.ItemService;
import com.springclass.firstproject.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;


    @Override
    public String saveItem(ItemDTO itemDTO) {
//        Item item=new Item(
//                itemDTO.getItemId(),
//                itemDTO.getItemName(),
//                itemDTO.getMeasuringUnitType(),
//                itemDTO.getBlanceQty(),
//                itemDTO.getSupplierPrice(),
//                itemDTO.getSellerPrice(),
//                itemDTO.isActiveStates()
//        );

        Item item=modelMapper.map(itemDTO,Item.class);
        itemRepo.save(item);
        return item.getItemName()+"saved";
    }

    @Override
    public List<ItemGetResponseDTO> getItembyQtyandStatus(double qty, boolean status) {
        List<Item> item=itemRepo.findAllByBlanceQtyEqualsAndActiveStatesEquals(qty,status);

        if(item.size() >0){
           List<ItemGetResponseDTO> itemGetResponseDTOS=modelMapper.map(item,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
           return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Error");
        }

    }

    @Override
    public String deleteCustomer(int itemId) {
        if(itemRepo.existsById(itemId)){
            itemRepo.deleteById(itemId);
            return "Delete Successfully"+itemId;
        }
        else {
            throw new RuntimeException("NOT FOUND THE ITEAM FOR PROVIDED ID");
        }
    }

    @Override
    public ItemDTO updateItem(IteamUpdateDTO iteamUpdateDTO) {
        if(itemRepo.existsById(iteamUpdateDTO.getItemId())){
            Item item=itemRepo.getReferenceById(iteamUpdateDTO.getItemId());
            item.setBlanceQty(iteamUpdateDTO.getBlanceQty());
            item.setSellerPrice(iteamUpdateDTO.getSellerPrice());
            item.setSupplierPrice(iteamUpdateDTO.getSupplierPrice());

            ItemDTO itemDTO=new ItemDTO(
                    item.getItemId(),
                    item.getItemName(),
                    item.getMeasuringUnitType(),
                    item.getBlanceQty(),
                    item.getSupplierPrice(),
                    item.getSellerPrice(),
                    item.isActiveStates()
            );

            return itemDTO;
        }
        else {
            throw new RuntimeException("NOT ITEAM FOR PROVIDED ID");
        }
    }

    @Override
    public PagenatedResponaseItemDTO getItemByStatusPagenated(boolean status, int page, int size) {
        Page<Item> items=itemRepo.findAllByActiveStatesEquals(status, PageRequest.of(page,size));

        if(items.getSize()<1){
            throw new RuntimeException("No Data");
        }

        //List<ItemDTO> itemDTOS=itemMapper.pageToDTO(items);
        PagenatedResponaseItemDTO pagenatedResponaseItemDTO=new PagenatedResponaseItemDTO(
                 itemMapper.pageToDTO(items),
                itemRepo.countAllByActiveStatesEquals(status)
        );

        return pagenatedResponaseItemDTO;
    }

    @Override
    public List<ItemGetResponseDTO> getItembyQtyandStatusByMapstruct(double qty, boolean status) {
        List<Item> item=itemRepo.findAllByBlanceQtyEqualsAndActiveStatesEquals(qty,status);

        if(item.size() >0){
            List<ItemGetResponseDTO> itemGetResponseDTOS=itemMapper.entityListToResponseDTOList(item);
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Error");
        }
    }
}
