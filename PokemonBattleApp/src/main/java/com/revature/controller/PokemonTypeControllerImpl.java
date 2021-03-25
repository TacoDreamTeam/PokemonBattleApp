package com.revature.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.service.PokemonTypeService;

public class PokemonTypeControllerImpl implements PokemonTypeController {

	private static Logger logger = Logger.getLogger(PokemonTypeControllerImpl.class);
	
	@Autowired
	private PokemonTypeService pokemonTypeService;

	public PokemonTypeControllerImpl() {
		logger.trace("Injection session factory bean, PokemonTypeControllerImpl");
	}
	
	@Override
	public void insert() {
		// TODO Auto-generated method stub

	}

	@Override
	public double effectivness(String type1, String type2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
