package com.xworkz.hibernate.entity;

public class JpaTester {
	
		
		public static void main(String[] args) {
			
			RestaurantEntity entity = new RestaurantEntity();
			entity.setCoNo(125478);
			entity.setType("non veg");
			entity.setName("Shrishial Khanavali");
			entity.setRestaurantId(3);
			entity.setRating(5);
			
			RestaurantDAO jpaDao=new RestaurantDAO();
			jpaDao.saveRestaurant(entity);
			System.out.println("saved sucessfully....!");
		}

	}


