package com.pizza.delivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.delivery.dto.OrderDTO;

import com.pizza.delivery.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
		List <OrderDTO> list = orderService.findaAll();
		return ResponseEntity.ok().body(list);
	}
}
