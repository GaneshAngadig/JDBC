package com.xworkz.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="restaurent")
public class RestaurantEntity {
	@Id
	@Column(name="id")
	private int restaurantId;
	private long coNo;
	private String name;
	private String type;
	private double rating;
	private String location;

}
