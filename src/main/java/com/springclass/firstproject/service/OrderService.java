package com.springclass.firstproject.service;

import com.springclass.firstproject.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String saveOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
