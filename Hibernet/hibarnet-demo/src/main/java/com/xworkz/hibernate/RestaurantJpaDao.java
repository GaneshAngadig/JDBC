	package com.xworkz.hibernate.dao;
	import com.xworkz.hibernate.entity.RestaurantEntity;
	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityManagerFactory;
	import jakarta.persistence.Persistence;
	public class RestaurantJpaDao 
	{

			
			public void saveRestaurantJPA(RestaurantEntity entity) {
				
			
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "ganesh" );
		    
		    EntityManager entitymanager = emfactory.createEntityManager( );
		    entitymanager.getTransaction().begin( );

		       entitymanager.persist( entity );
		    entitymanager.getTransaction( ).commit( );

		    entitymanager.close( );
		    emfactory.close( );
			}

		}

