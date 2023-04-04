package com.springclass.firstproject.service.impl;

import com.springclass.firstproject.dto.request.RequestOrderSaveDTO;
import com.springclass.firstproject.dto.response.ItemGetResponseDTO;
import com.springclass.firstproject.entity.Order;
import com.springclass.firstproject.entity.OrderItem;
import com.springclass.firstproject.repo.CustomerRepo;
import com.springclass.firstproject.repo.ItemRepo;
import com.springclass.firstproject.repo.OrderItemRepo;
import com.springclass.firstproject.repo.OrderRepo;
import com.springclass.firstproject.service.CustomerService;
import com.springclass.firstproject.service.OrderService;
import com.springclass.firstproject.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional
    public String saveOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order= new Order(
                customerRepo.getReferenceById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getOrderDate(),
                requestOrderSaveDTO.getTotalAmount()
        );
        orderRepo.save(order);
        if(orderRepo.existsById(order.getOrderId())){
         // List<OrderItem> orderItemList=;
            List<OrderItem> orderItemList=modelMapper.map(requestOrderSaveDTO.getOrderItems(),new TypeToken<List<OrderItem>>(){}.getType());
            for(int i=0;i<orderItemList.size();i++){
                orderItemList.get(i).setOrders(order);
                orderItemList.get(i).setItems(itemRepo.getReferenceById(requestOrderSaveDTO.getOrderItems().get(i).getItems()));

            }
            if(orderItemList.size()>0){
                orderItemRepo.saveAll(orderItemList);
            }
            return "Order successfully saved";
        }
        return null;
    }
}
