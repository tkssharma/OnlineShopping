package com.online.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping.entity.Cart;

import com.online.shopping.entity.*;


public interface RoleRepository extends JpaRepository<Role, Integer> {

}
