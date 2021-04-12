package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.models.Pokemon;
import com.revature.service.PokemonService;


@Controller("pokemonController")
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonControllerImpl implements PokemonController {

	private static Logger logger = Logger.getLogger(PokemonControllerImpl.class);
	
	@Autowired
	private PokemonService pokemonService;
	
	@PostMapping("/PokemonInsert")
	public @ResponseBody ClientMessage insertPokemon(@RequestBody Pokemon pokemon) {
		System.out.println("adding the pokemon (control)");
		logger.debug("adding the pokemon (control)");
		return(pokemonService.insertPokemon(pokemon)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@GetMapping("/PokemonGetAll")
	public @ResponseBody List<Pokemon> selectAllPokemon() {
		System.out.println("getting all the pokemon (control)");
		logger.debug("getting all the pokemon (control)");
		return pokemonService.selectAllPokemon();
	}
	
	@PostMapping("/PokemonGetById")
	public @ResponseBody Pokemon FindPokemonById(@RequestBody Pokemon pokemon) {
		System.out.println("finding the pokemon by id (control)");
		logger.debug("finding the pokemon by id (control)");
		return pokemonService.FindPokemonById(pokemon.getId());
	}
	
	@PostMapping("/PokemonUpdate")
	public @ResponseBody ClientMessage updatePokemon(@RequestBody Pokemon pokemon) {
		System.out.println("updating the pokemon (control)");
		logger.debug("updating the pokemon (control)");
		return(pokemonService.updatePokemon(pokemon)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}


	@PostMapping("/PokemonDelete")
	public @ResponseBody ClientMessage deletePokemon(@RequestBody Pokemon pokemon) {
		System.out.println("deleting the pokemon (control)");
		logger.debug("deleting the pokemon (control)");
		return(pokemonService.deletePokemon(pokemon.getId())) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
		
	}

}
