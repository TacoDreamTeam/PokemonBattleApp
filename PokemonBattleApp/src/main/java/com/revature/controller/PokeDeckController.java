package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.models.PokeDeck;

public interface PokeDeckController {

	public void insertDeck(PokeDeck pokedeck);
	
	public List<PokeDeck> selectAllDecks();
	
	public PokeDeck FindDeckById(int id, HttpServletRequest request); //viewing pokemon in your Pokedex
	
	public void deleteDeck(int id); 
	
	//add an update deck?
	
}
