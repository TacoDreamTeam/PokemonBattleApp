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
		return(pokemonService.insertPokemon(pokemon)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@PostMapping("/PokemonkUpdate")
	public void updatePokemon(@RequestBody Pokemon pokemon) {
		pokemonService.updatePokemon(pokemon);
	}

	@GetMapping("/PokemonGetAll")
	public @ResponseBody List<Pokemon> selectAllPokemon() {
		return pokemonService.selectAllPokemon();
	}

	@PostMapping("/PokemonGetById")
	public @ResponseBody Pokemon FindPokemonById(@RequestBody int id) {
		return pokemonService.FindPokemonById(id);
	}

	@PostMapping("/PokemonUpdate")
	public void deletePokemon(@RequestBody int id) {
		pokemonService.deletePokemon(id);
		
	}

}
