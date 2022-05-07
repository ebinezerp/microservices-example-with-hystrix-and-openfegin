package com.example.userms;

import com.example.userms.model.OrderList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "orderms")
public interface OrderServiceProxy {

    @GetMapping("/orders/user/{id}")
    ResponseEntity<OrderList> getOrders(@PathVariable("id") String userId);
}
