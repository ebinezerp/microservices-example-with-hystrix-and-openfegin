package com.example.userms.controller;

import com.example.userms.model.Order;
import com.example.userms.model.OrderList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/userms")
public class UserController {

    @GetMapping("/user/{id}/orders")
    @HystrixCommand(fallbackMethod = "handlingFallback")
    public ResponseEntity<List<Order>> getOrders(@PathVariable("id") String userId) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<OrderList> orderList = template.getForEntity(URI.create("http://localhost:10001/orderms/orders/user/1"), OrderList.class);
        return new ResponseEntity<>(orderList.getBody()
                .getOrders(), HttpStatus.OK);
    }

    public ResponseEntity<List<Order>> handlingFallback(@PathVariable("id") String userId){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

}
