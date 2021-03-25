package com.revature.controller;

import java.util.List;

import com.revature.ajax.ClientMessage;
import com.revature.models.Pokemon;

public interface PokemonController {

	public ClientMessage insertPokemon(Pokemon pokemon);
	
	public void updatePokemon(Pokemon pokemon);
	
	public List<Pokemon> selectAllPokemon();
	
	public Pokemon FindPokemonById(int id);
	
	public void deletePokemon(int id);
	
}
