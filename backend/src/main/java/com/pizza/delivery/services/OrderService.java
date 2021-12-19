package com.pizza.delivery.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizza.delivery.dto.OrderDTO;

import com.pizza.delivery.entities.Order;

import com.pizza.delivery.repositories.OrderRespository;




@Service
public class OrderService {
	
	@Autowired
	private OrderRespository orderRepository;
	
	@Transactional(readOnly = true)
	public List <OrderDTO> findaAll() {
		List <Order> list =  orderRepository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

}
