package com.springclass.firstproject.controller;

import com.springclass.firstproject.dto.ItemDTO;
import com.springclass.firstproject.dto.pagenated.PagenatedResponaseItemDTO;
import com.springclass.firstproject.dto.request.IteamUpdateDTO;
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
    public ResponseEntity<StanderdResponse> getItemByQtyandStatus(
            @RequestParam(value = "qty") double qty,
            @RequestParam(value = "status") boolean status){
        List<ItemGetResponseDTO> itemGetResponseDTOS=itemService.getItembyQtyandStatus(qty,status);
        return new ResponseEntity<>(
                new StanderdResponse(200,"Successful",itemGetResponseDTOS),
                HttpStatus.OK
        );

    }

    @GetMapping(
            path = "get-by-name-and-status-by-mapstruct",
            params = {"qty","status"}
    )
    public ResponseEntity<StanderdResponse> getItemByQtyandStatuswithbyMapstruct(
            @RequestParam(value = "qty") double qty,
            @RequestParam(value = "status") boolean status){
        List<ItemGetResponseDTO> itemGetResponseDTOS=itemService.getItembyQtyandStatusByMapstruct(qty,status);
        return new ResponseEntity<>(
                new StanderdResponse(200,"Successful",itemGetResponseDTOS),
                HttpStatus.OK
        );

    }


    @DeleteMapping(
            path = "/delete-by-id/{id}"
    )
    public ResponseEntity<StanderdResponse> deleteIteamById(@PathVariable(value = "id") String itemId){
        String message=itemService.deleteCustomer(itemId);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Successfull",message),
                HttpStatus.OK
        );
    }

    @PutMapping(path = "/update-item")
    public ResponseEntity<StanderdResponse> updateItem(@RequestBody IteamUpdateDTO iteamUpdateDTO){
        ItemDTO itemDTO=itemService.updateItem(iteamUpdateDTO);
        return new ResponseEntity<StanderdResponse>(
                new StanderdResponse(200,"Successful",itemDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "get=all-customers-by-page",
            params = {"activeStatus","size","page"}
    )
    public ResponseEntity<StanderdResponse> getAllItemsByPage(
            @RequestParam(value = "activeStatus") boolean status,
            @RequestParam(value = "size") int size,
            @RequestParam(value="page")int page
            )
    {
        PagenatedResponaseItemDTO pagenatedResponaseItemDTO=itemService.getItemByStatusPagenated(status,page,size);
        return  new ResponseEntity<>(
           new StanderdResponse(200,"Data comes",pagenatedResponaseItemDTO),HttpStatus.OK
        );
    }


}
