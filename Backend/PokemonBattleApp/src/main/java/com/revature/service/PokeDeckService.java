package com.revature.service;

import java.util.List;

import com.revature.models.PokeDeck;

public interface PokeDeckService {
	
	public boolean insertDeck(PokeDeck pokedeck);
	
	public List<PokeDeck> selectAllDecks();
	
	public PokeDeck FindDeckById(int id);
	
	public boolean deleteDeck(int id);

	public boolean updateDeck(PokeDeck pokedeck);

	public List<PokeDeck> FindDeckByTrainerId(int trainerId);
}
