package com.revature.service;

import java.util.List;

import com.revature.models.Pokemon;

public interface PokemonService {
		
	public boolean insertPokemon(Pokemon pokemon);
	
	public void updatePokemon(Pokemon pokemon);
	
	public List<Pokemon> selectAllPokemon();
	
	public Pokemon FindPokemonById(int id);
	
	public void deletePokemon(int id);
}

