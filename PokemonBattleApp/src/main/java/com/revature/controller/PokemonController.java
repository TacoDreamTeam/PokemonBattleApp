package com.revature.controller;

import java.util.List;

import com.revature.models.Pokemon;

public interface PokemonController {

	public void insertPokemon(Pokemon pokemon); 
	
	public void updatePokemon(Pokemon pokemon);
	
	public List<Pokemon> selectAllPokemon();
	
	public Pokemon FindPokemonById(int id);
	
}
