package com.revature.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.EffectiveTemplate;
import com.revature.service.PokemonTypeService;

@Controller("pokemonTypeController")
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonTypeControllerImpl implements PokemonTypeController {

	private static Logger logger = Logger.getLogger(PokemonTypeControllerImpl.class);
	
	@Autowired
	private PokemonTypeService pokemonTypeService;
	
//	public PokemonTypeControllerImpl() {
//		logger.trace("Injection session factory bean, PokemonTypeControllerImpl");
//	}
	
	@PostMapping("/PokemonTypeInsert")
	public void insert() {
		pokemonTypeService.insert();
	}

	@PostMapping("/PokemonTypeEffectivness")
	public @ResponseBody double effectivness(@RequestBody EffectiveTemplate effectiveTemplate) {
		return pokemonTypeService.effectivness(effectiveTemplate.getType1(), effectiveTemplate.getType2());
	}

}
