package com.revature.scratch;

import com.revature.repo.PokemonTypeDao;

public class Scratch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PokemonTypeDao PTD=new PokemonTypeDao();
		PTD.insert();
		System.out.println("done");
	}

}