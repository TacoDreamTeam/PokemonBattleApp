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
		logger.trace("Injection using Autowired PokemonService in PokemonServiceImpl");
	}
	
	@Override
	public boolean insertPokemon(Pokemon pokemon) {
		logger.debug("adding the pokemon (service)");
		System.out.println("adding the pokemon (service)");
		pokemonDao.insertPokemon(pokemon);
		return pokemon.getId()!=0;
	}

	@Override
	public List<Pokemon> selectAllPokemon() {
		logger.debug("getting all the pokemon (service)");
		System.out.println("getting all the pokemon (service)");
		return pokemonDao.selectAllPokemon();
	}

	@Override
	public Pokemon FindPokemonById(int id) {
		logger.debug("finding the pokemon by id (service)");
		System.out.println("finding the pokemon by id (service)");
		return pokemonDao.FindPokemonById(id);
	}
	
	@Override
	public boolean updatePokemon(Pokemon pokemon) {
		logger.debug("updating the pokemon (service)");
		System.out.println("updating the pokemon (service)");
		pokemonDao.updatePokemon(pokemon);
		return pokemon.equals(pokemonDao.FindPokemonById(pokemon.getId()));
	}

	@Override
	public boolean deletePokemon(int id) {
		logger.debug("deleting the pokemon (service)");
		System.out.println("deleting the pokemon (service)");
		pokemonDao.deletePokemon(id);
		return pokemonDao.FindPokemonById(id)==null;
	}
}