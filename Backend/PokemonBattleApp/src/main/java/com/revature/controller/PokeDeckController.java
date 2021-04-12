package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.models.PokeDeck;

public interface PokeDeckController {

	public ClientMessage insertDeck(PokeDeck pokedeck);
	
	public List<PokeDeck> selectAllDecks();
	
	//public PokeDeck FindDeckById(int id, HttpServletRequest request); //viewing pokemon in your Pokedex
	
	public PokeDeck FindDeckById(PokeDeck pokedeck, HttpServletRequest request);
	
	//public void deleteDeck(int id);
	
	public ClientMessage deleteDeck(PokeDeck pokedeck);
	
	public @ResponseBody ClientMessage updateDeck(PokeDeck pokedeck);
}

