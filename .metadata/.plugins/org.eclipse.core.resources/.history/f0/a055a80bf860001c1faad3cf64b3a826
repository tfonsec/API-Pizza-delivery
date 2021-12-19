package com.pizza.delivery.services;

import java.time.Instant;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizza.delivery.dto.OrderDTO;
import com.pizza.delivery.dto.ProductDTO;
import com.pizza.delivery.entities.Order;
import com.pizza.delivery.entities.OrderStatus;
import com.pizza.delivery.entities.Product;
import com.pizza.delivery.repositories.OrderRespository;
import com.pizza.delivery.repositories.ProductRepository;




@Service
public class OrderService {
	
	@Autowired
	private OrderRespository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List <OrderDTO> findaAll() {
		List <Order> list =  orderRepository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO orderDTO) {
		Order order = new Order(null, orderDTO.getAddress(),
				orderDTO.getLatitude(), 
				orderDTO.getLongitude(),
				Instant.now(),
				OrderStatus.PENDING);
		for(ProductDTO productDTO : orderDTO.getProducts()) {
			Product product = productRepository.getById(productDTO.getId());
			order.getProducts().add(product);
		}
		order = orderRepository.save(order);
		return new OrderDTO(order);
	}

}
