package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.revature.util.ClientMessageUtil.*;

import com.revature.ajax.ClientMessage;
import com.revature.models.PokeDeck;
import com.revature.service.PokeDeckService;

@Controller("pokeDeckController")
@CrossOrigin(origins = "http://localhost:4200")
public class PokeDeckControllerImpl implements PokeDeckController {

	private static Logger logger = Logger.getLogger(PokeDeckControllerImpl.class);
	
	@Autowired
	private PokeDeckService pokeDeckService;
	
//	public PokeDeckControllerImpl() {
//		logger.trace("Injection session factory bean, PokeDeckControllerImpl");
//	}
	
	@PostMapping("/PokeDeckInsert")
	public @ResponseBody ClientMessage insertDeck(@RequestBody PokeDeck pokedeck) {
		return(pokeDeckService.insertDeck(pokedeck)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@GetMapping("/PokeDeckGetAll")
	public @ResponseBody List<PokeDeck> selectAllDecks() {
		return pokeDeckService.selectAllDecks();
	}

	@PostMapping("/PokeDeckGetById")
	public @ResponseBody PokeDeck FindDeckById(@RequestBody PokeDeck pokedeck, HttpServletRequest request) {
		request.getSession();
		return pokeDeckService.FindDeckById(pokedeck.getId());
	}
	
	@PostMapping("/PokeDeckGetByTrainerId")
	public @ResponseBody List<PokeDeck> FindDeckByTrianerId(@RequestBody PokeDeck pokedeck, HttpServletRequest request) {
		request.getSession();
		return pokeDeckService.FindDeckByTrainerId(pokedeck.getTrainerId());
	}

	@PostMapping("/PokeDeckUpdate")
	public @ResponseBody ClientMessage updateDeck(@RequestBody PokeDeck pokedeck) {
		return(pokeDeckService.updateDeck(pokedeck)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}
	
	@PostMapping("/PokeDeckDelete")
	public @ResponseBody ClientMessage deleteDeck(@RequestBody PokeDeck pokedeck) {
		return(pokeDeckService.deleteDeck(pokedeck.getId())) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

}
