package com.pizza.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizza.delivery.entities.Order;



public interface OrderRespository extends JpaRepository <Order, Long>{

}
