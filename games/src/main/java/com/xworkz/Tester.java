package com.xworkz;

import java.util.Scanner;

import com.xworkz.GamesDTO.GameDTO;
import com.xworkz.gamesDAO.GamesDAO;




public class Tester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter a game id ");
		int id = scanner.nextInt();

		System.out.println("enter a game name ");
		String name = scanner.next();

		System.out.println("Enter a no of playes ");
		int player = scanner.nextInt();

		System.out.println("Enetr a game type");
		String type = scanner.next();

		GameDTO dto = new GameDTO(id, name, player, type);

		boolean SaveStatus = GamesDAO.saveGame(dto);
		if (SaveStatus) {
			System.out.println("Save Successfully");
		} else {
			System.out.println("Save Unsuccessfully");
		}

	}

}