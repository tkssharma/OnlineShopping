package com.online.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;





import com.online.shopping.entity.*;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findOneByName(String name);
	

}
