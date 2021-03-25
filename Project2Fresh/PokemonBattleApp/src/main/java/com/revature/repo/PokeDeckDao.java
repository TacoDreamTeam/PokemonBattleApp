package com.revature.repo;

import java.util.List;

import com.revature.models.PokeDeck;

public interface PokeDeckDao {

	public void insertDeck(PokeDeck pokedeck);
	
	public List<PokeDeck> selectAllDecks();
	
	public PokeDeck FindDeckById(int id);
	
	public void deleteDeck(int id);
	
	public void updateDeck(PokeDeck pokedeck);
	
}
