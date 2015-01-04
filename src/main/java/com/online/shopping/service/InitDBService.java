package com.online.shopping.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
public class InitDBService {


	@Autowired
	public UserRepository userRepo;

	@Autowired
	public RoleRepository roleRepo;

	@Autowired
	public CartRepository cartRepo;

	@Autowired
	public ProductRepository productRepo;



	@PostConstruct
	public void Initilize()
	{
		Role userrole = new Role();
		userrole.setName("USER_ROLE");
		roleRepo.save(userrole);
		
		Role adminrole = new Role();
		adminrole.setName("ADMIN_ROLE");
		roleRepo.save(adminrole);

		List<Role> roles = new ArrayList<Role>();
		roles.add(userrole);
	    roles.add(adminrole);
		User useradmin = new User();
		useradmin.setRoles(roles);
		useradmin.setName("admin");
		useradmin.setEmail("admin@gmail.com");
		useradmin.setMobNumber("90879766");
		useradmin.setPassword("admin");
		useradmin.setEnabled(true);

		userRepo.save(useradmin);
		
		
		
		Cart admincart = new Cart();
		admincart.setDiscount("20");
		admincart.setName("admin_cart");
		admincart.setPrice(300);
		admincart.setUser(useradmin);
		admincart.setProduct_count("4");
		cartRepo.save(admincart);
		
		
		Products product1 = new  Products();
		product1.setBrand("adidas");
		product1.setCart(admincart);
		product1.setCategory("mens");
		product1.setProduct_name("mens shirt");
		productRepo.save(product1);
		
		
		Products product2 = new  Products();
		product2.setBrand("adidas");
		product2.setCart(admincart);
		product2.setCategory("mens");
		product2.setProduct_name("mens shirt");
		productRepo.save(product2);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		




	}

	@PreDestroy
	public void destroy()
	{

	}




}
