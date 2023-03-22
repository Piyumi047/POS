package com.springclass.firstproject.controller;

import com.springclass.firstproject.dto.ItemDTO;
import com.springclass.firstproject.dto.response.ItemGetResponseDTO;
import com.springclass.firstproject.service.ItemService;
import com.springclass.firstproject.util.StanderdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @PostMapping("/save")
//    public String saveItem(@RequestBody ItemDTO itemDTO){
//        String message=itemService.saveItem(itemDTO);
//        return message;
//    }

    @PostMapping("/save")
    public ResponseEntity<StanderdResponse> saveItem(@RequestBody ItemDTO itemDTO){
        String message=itemService.saveItem(itemDTO);

//        ResponseEntity<StanderdResponse> responseEntity=new ResponseEntity<StanderdResponse>(
//                new StanderdResponse(201,"Successfully saved",itemDTO), HttpStatus.CREATED
//        );
//        return responseEntity;

        return new ResponseEntity<>(
                new StanderdResponse(201,"Successfully saved",itemDTO),HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "get-by-name-and-status",
            params = {"qty","status"}
    )
    public List<ItemGetResponseDTO> getItemByQtyandStatus(
            @RequestParam(value = "qty") double qty,
            @RequestParam(value = "status") boolean status){
        List<ItemGetResponseDTO> itemGetResponseDTOS=itemService.getItembyQtyandStatus(qty,status);
        return itemGetResponseDTOS;

    }


}
