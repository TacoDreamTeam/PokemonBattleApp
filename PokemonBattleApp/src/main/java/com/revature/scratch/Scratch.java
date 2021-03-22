package com.revature.scratch;

import com.revature.repo.PokemonTypeDao;
import com.revature.service.Service;

public class Scratch {

	public static void main(String[] args) {
		testPokemonTypeDao();
		testLogin();	
	}
	
	public static void testPokemonTypeDao() {
		// TODO Auto-generated method stub
		PokemonTypeDao PTD=new PokemonTypeDao();
		//PTD.insert();
		//System.out.println("done");
	
		double effective=PTD.effectivness("normal", "ghost");
		//System.out.println();
		System.out.println("effectivness: "+effective);
		System.out.println("done");
	}
	
	
	
	public static void testLogin() {
		System.out.println(Service.login("johndoe", "pass"));
	}

}