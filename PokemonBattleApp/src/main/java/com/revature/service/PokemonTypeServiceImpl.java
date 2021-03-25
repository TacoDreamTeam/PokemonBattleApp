package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repo.PokemonTypeDao;

@Service("PokemonTypeService")
public class PokemonTypeServiceImpl implements PokemonTypeService {

	private Logger logger = Logger.getLogger(PokemonTypeServiceImpl.class);
	
	@Autowired
	private PokemonTypeDao pokemonTypeDao;	
	
	public PokemonTypeServiceImpl() {
		logger.trace("Injection using Autowired PokemonTypeDao in PokemonTypeServiceImpl");
	}
	
	
	@Override
	public void insert() {
		pokemonTypeDao.insert();
	}

	@Override
	public double effectivness(String type1, String type2) {
		return pokemonTypeDao.effectivness(type1, type2);
	}

}
