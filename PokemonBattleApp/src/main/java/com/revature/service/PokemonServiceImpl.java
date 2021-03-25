package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Pokemon;
import com.revature.repo.PokemonDao;

@Service("PokemonService")
public class PokemonServiceImpl implements PokemonService {

	private Logger logger = Logger.getLogger(PokemonServiceImpl.class);
	
	@Autowired
	private PokemonDao pokemonDao;
	
	
	
	public PokemonServiceImpl() {
		super();
		logger.trace("Injection using Autowired PokemonDao in PokemonServiceImpl");
	}

	@Override
	public void insertPokemon(Pokemon pokemon) {
		pokemonDao.insertPokemon(pokemon);//change to boolean 
		//return pokemon.getId()!=0;
	}

	@Override
	public void updatePokemon(Pokemon pokemon) {
		pokemonDao.updatePokemon(pokemon);//change to boolean 
		//return pokemon.getId()!=0;
	}

	@Override
	public List<Pokemon> selectAllPokemon() {
		return pokemonDao.selectAllPokemon();
	}

	@Override
	public Pokemon FindPokemonById(int id) {
		return pokemonDao.FindPokemonById(id);
	}

}
