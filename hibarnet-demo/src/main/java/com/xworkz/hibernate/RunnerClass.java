package com.xworkz.hibernate;

import com.xworkz.hibernate.dao.RestaurantDAO;
import com.xworkz.hibernate.entity.RestaurantEntity;

public class RunnerClass {
	public static void main(String[] args) {
		RestaurantEntity restaurantEntity = new RestaurantEntity();
		restaurantEntity.setRestaurantId(1);
		restaurantEntity.setCoNo(7829187687l);
		restaurantEntity.setName("Udupi Garden");
		restaurantEntity.setType("Veg");
		restaurantEntity.setRating(4.0);
		restaurantEntity.setLocation("Rajajinagar");

		RestaurantDAO restaurantDAO = new RestaurantDAO();
		restaurantDAO.saveRestaurant(restaurantEntity);
		System.out.println("Saved Succesfully");
	}

}
