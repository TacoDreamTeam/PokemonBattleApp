package com.revature.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.models.PokeDeck;
import com.revature.models.Pokemon;
import com.revature.models.Team;
import com.revature.models.Trades;
import com.revature.models.Trainer;
import com.revature.repo.PokeDeckDao;
import com.revature.repo.PokemonDao;
import com.revature.repo.PokemonTypeDao;
import com.revature.repo.TeamDao;
import com.revature.repo.TradesDao;
import com.revature.repo.TrainerDao;

public class DaoTester {

	private TrainerDao trainerDao = new TrainerDao();
	private PokemonDao pokemonDao = new PokemonDao();
	private PokeDeckDao pokeDeckDao = new PokeDeckDao();
	private PokemonTypeDao pokeTypeDao = new PokemonTypeDao();
	private TradesDao tradeDao = new TradesDao();
	private TeamDao teamDao = new TeamDao();
	
	Trainer t1 = new Trainer(1,"johndoe", "pass", "john", "doe");
	PokeDeck pdFort1 = new PokeDeck(2,1, 22);
	Pokemon pokemon1 = new Pokemon(3, 1, "Something Pokemon", 2);
	Team t1Team = new Team(1, 1, 22, 33, 44, 11);
	Trades trade = new Trades(5, 1,22,1,"Accept");
	
	Trainer t2 = new Trainer("pokeBlue", "passcode", "Jane", "Doe");
	PokeDeck pdFor2 = new PokeDeck(2, 23);
	Pokemon pokemon2 = new Pokemon(2, "Charzard", 3);
	Team t2Team = new Team(2, 23, 45, 77);
	Trades secondTrade = new Trades(2, 77, 44, "Denied");
	
	Trainer t3 = new Trainer("pokeRed", "pass1234", "Alex", "Bell");
	PokeDeck pdFor3 = new PokeDeck(3, 13);
	Pokemon pokemon3 = new Pokemon(3, "Squirtle", 7);
	Team t3Team = new Team(3, 55, 21, 89, 120, 20);
	
	
	@Test
	public void testInsertTrainer() {
		
		Trainer Dbt2 = trainerDao.selectTrainerByUsername("pokeBlue");
		Trainer Dbt3 = trainerDao.selectTrainerByUsername("johndoe");
		
		assertEquals(t1, Dbt3);
	}
	
	@Test
	public void testInsertPokemon() {
		
		Pokemon dbPokemon = pokemonDao.FindPokemonById(3);
		
		assertEquals(pokemon1, dbPokemon);
	}
	
	@Test
	public void testInsertDecks() {
		
		PokeDeck dbDeck = pokeDeckDao.FindDeckById(2);
		
		assertEquals(pdFort1, dbDeck);
	}
	
	@Test
	public void testInsertTrades() {
		
		Trades dbTrade = tradeDao.FindTradesById(5);
		
		assertEquals(trade, dbTrade);
	}
	
	@Test
	public void testInsertTeams() {

		
	}
}