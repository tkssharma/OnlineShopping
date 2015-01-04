package com.online.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.shopping.entity.*;


public interface ProductRepository extends JpaRepository<Products, Integer> {

	List<Products> findByCart(Cart cart);

}
