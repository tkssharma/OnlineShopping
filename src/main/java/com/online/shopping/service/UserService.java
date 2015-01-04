package com.online.shopping.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.entity.Cart;
import com.online.shopping.entity.Products;
import com.online.shopping.entity.Role;
import com.online.shopping.entity.User;
import com.online.shopping.repository.CartRepository;
import com.online.shopping.repository.ProductRepository;
import com.online.shopping.repository.RoleRepository;
import com.online.shopping.repository.UserRepository;



@Service
@Transactional
public class UserService {

	@Autowired
	public UserRepository userRepo;

	@Autowired
	public RoleRepository roleRepo;

	@Autowired
	public CartRepository cartRepo;

	@Autowired
	public ProductRepository productRepo;

	public  List<User> findAll() {
		List<User> userlist = userRepo.findAll();
		return userlist;
	}

	public  User findOnewithCartId(int id) {

		User user = findOne(id);

		Cart cart = cartRepo.findByUser(user);
		if(cart != null){
			List<Products> product = productRepo.findByCart(cart);
			cart.setProducts(product);
			user.setCart(cart);
		}
		return user;
	}

	private User findOne(int id) {
		return userRepo.findOne(id);
	}

	public void save(User user) {
		user.setEnabled(true);
		user.setMobNumber("9789877676");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepo.findOne(1));
		user.setRoles(roles);
		userRepo.save(user);

	}

	public User findOnewithName(String name) {
		User user = userRepo.findOne(1);
		Cart cart = cartRepo.findByUser(user);
		if(cart != null){
			List<Products> product = productRepo.findByCart(cart);
			cart.setProducts(product);
			user.setCart(cart);
		}
		return user;
	
	}

}
