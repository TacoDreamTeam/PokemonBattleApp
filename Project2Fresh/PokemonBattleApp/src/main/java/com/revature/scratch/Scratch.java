package com.revature.scratch;

import com.revature.service.PokeDeckService;
import com.revature.service.PokeDeckServiceImpl;

public class Scratch {

	public static void main(String[] args) {
		PokeDeckService PDS =new PokeDeckServiceImpl();
		//System.out.println(PDS.FindDeckById(3));
		System.out.println(PDS.selectAllDecks());
	}

}
