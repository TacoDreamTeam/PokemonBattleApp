package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Pokemon;
import com.revature.service.PokemonService;

public class PokemonControllerImpl implements PokemonController {

	private static Logger logger = Logger.getLogger(PokemonControllerImpl.class);
	
	@Autowired
	private PokemonService pokemonService;
	
	public PokemonControllerImpl() {
		logger.trace("Injection session factory bean, PokemonControllerImpl");
	}
	
	@Override
	public void insertPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Pokemon> selectAllPokemon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pokemon FindPokemonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
