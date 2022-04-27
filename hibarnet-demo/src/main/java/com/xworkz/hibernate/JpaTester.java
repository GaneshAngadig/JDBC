package com.xworkz.hibernate;

import com.xworkz.hibernate.dao.RestaurantDAO;
import com.xworkz.hibernate.entity.RestaurantEntity;

public class JpaTester {
	
		
		public static void main(String[] args) {
			
			RestaurantEntity entity = new RestaurantEntity();
			entity.setCoNo(125478);
			entity.setType("non veg");
			entity.setName("ganesh Khanavali");
			entity.setRestaurantId(2);
			entity.setRating(5);
			
			RestaurantDAO jpaDao=new RestaurantDAO();
			jpaDao.saveRestaurant(entity);
			System.out.println("saved sucessfully....!");
		}

	}


