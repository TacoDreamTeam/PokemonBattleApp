package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public @ResponseBody PokeDeck FindDeckById(@RequestBody int id, HttpServletRequest request) {
		request.getSession();
		return pokeDeckService.FindDeckById(id);
	}

	@PostMapping("/PokeDeckDelete")
	public void deleteDeck(int id) {
		pokeDeckService.deleteDeck(id);
	}

	@PostMapping("/PokeDeckUpdate")
	public void updateDeck(@RequestBody PokeDeck pokedeck) {
		pokeDeckService.updateDeck(pokedeck);
	}

}
