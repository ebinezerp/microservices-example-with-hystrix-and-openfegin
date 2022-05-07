package com.example.orderms.controller;


import com.example.orderms.model.Order;
import com.example.orderms.model.OrderList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orderms")
public class OrderController {

    @GetMapping("/orders/user/{id}")
    public ResponseEntity<OrderList> getOrders(@PathVariable("id") String userId) {
        OrderList orderList = new OrderList();
        List<Order> orders = Arrays.asList(new Order("1"), new Order("2"));
        orderList.setOrders(orders);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

}
