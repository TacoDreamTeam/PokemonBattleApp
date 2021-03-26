package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.PokeDeck;
import com.revature.repo.PokeDeckDao;

@Service("pokeDeckService")
public class PokeDeckServiceImpl implements PokeDeckService {

	private Logger logger = Logger.getLogger(PokeDeckServiceImpl.class);
	
	@Autowired
	private PokeDeckDao pokeDeckDao;
	
	public PokeDeckServiceImpl() {
		super();
		logger.trace("Injection using Autowired PokeDeckDao in PokeDeckServiceImpl");
	}

	@Override
	public boolean insertDeck(PokeDeck pokedeck) {
		pokeDeckDao.insertDeck(pokedeck);//change to boolean 
		return pokedeck.getId()!=0;
	}

	@Override
	public List<PokeDeck> selectAllDecks() {
		return pokeDeckDao.selectAllDecks();
	}

	@Override
	public PokeDeck FindDeckById(int id) {
		return pokeDeckDao.FindDeckById(id);
	}

	@Override
	public boolean updateDeck(PokeDeck pokedeck) {
		pokeDeckDao.updateDeck(pokedeck);
		return pokedeck.equals(pokeDeckDao.FindDeckById(pokedeck.getId()));
	}
	
	@Override
	public boolean deleteDeck(int id) {
		pokeDeckDao.deleteDeck(id);
		return pokeDeckDao.FindDeckById(id)==null;
	}
}