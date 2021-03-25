package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.PokeDeck;
import com.revature.service.PokeDeckService;

@Controller("PokeDeckController")
public class PokeDeckControllerImpl implements PokeDeckController {

	private static Logger logger = Logger.getLogger(PokeDeckControllerImpl.class);
	
	@Autowired
	private PokeDeckService pokeDeckService;
	
	public PokeDeckControllerImpl() {
		logger.trace("Injection session factory bean, PokeDeckControllerImpl");
	}
	
	@PostMapping("/PokeDeckInsert")
	public void insertDeck(@RequestBody PokeDeck pokedeck) {
		pokeDeckService.insertDeck(pokedeck);
	}

	@GetMapping("/PokeDeckGetAll")
	public @ResponseBody List<PokeDeck> selectAllDecks() {
		return pokeDeckService.selectAllDecks();
	}

	@GetMapping("/PokeDeckGetById")
	public @ResponseBody PokeDeck FindDeckById(@RequestBody int id, HttpServletRequest request) {
		request.getSession();
		return pokeDeckService.FindDeckById(id);
	}

	@PostMapping("/PokeDeckDelete")
	public void deleteDeck(int id) {
		pokeDeckService.deleteDeck(id);
	}

}
