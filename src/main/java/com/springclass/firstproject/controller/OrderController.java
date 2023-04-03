package com.springclass.firstproject.controller;

import com.springclass.firstproject.dto.ItemDTO;
import com.springclass.firstproject.dto.request.RequestOrderSaveDTO;
import com.springclass.firstproject.util.StanderdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order")
public class OrderController {

    @PostMapping("/save")
    public ResponseEntity<StanderdResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        //String message=itemService.saveItem(itemDTO);
        System.out.println(requestOrderSaveDTO);

//        ResponseEntity<StanderdResponse> responseEntity=new ResponseEntity<StanderdResponse>(
//                new StanderdResponse(201,"Successfully saved",itemDTO), HttpStatus.CREATED
//        );
//        return responseEntity;

        return new ResponseEntity<>(
                new StanderdResponse(201,"Successfully saved",2), HttpStatus.CREATED
        );
    }
}
