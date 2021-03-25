package com.revature.repo;

import java.util.List;

import com.revature.models.Pokemon;

public interface PokemonDao {

	public void insertPokemon(Pokemon pokemon);
	
	public void updatePokemon(Pokemon pokemon);
	
	public List<Pokemon> selectAllPokemon();

	public Pokemon FindPokemonById(int id);
	
	public void deletePokemon(int id);
}
