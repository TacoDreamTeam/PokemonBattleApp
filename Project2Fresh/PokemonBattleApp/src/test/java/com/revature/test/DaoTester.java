package com.revature.test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.models.PokeDeck;
import com.revature.models.Pokemon;
import com.revature.models.Team;
import com.revature.models.Trades;
import com.revature.models.Trainer;
import com.revature.repo.PokeDeckDaoImpl;
import com.revature.repo.PokemonDaoImpl;
import com.revature.repo.TeamDaoImpl;
import com.revature.repo.TradesDaoImpl;
import com.revature.repo.TrainerDaoImpl;


@Component("test")
public class DaoTester {
	
	
	@Autowired
	private TrainerDaoImpl trainerDao;

	@Autowired
	private PokemonDaoImpl pokemonDao;

	@Autowired
	private PokeDeckDaoImpl pokeDeckDao;
	
	@Autowired
	private TradesDaoImpl tradeDao;
	
	@Autowired
	private TeamDaoImpl teamDao;
	
	
	
//	private TrainerDaoImpl trainerDao = new TrainerDaoImpl();
//	private PokemonDaoImpl pokemonDao = new PokemonDaoImpl();
//	private PokeDeckDaoImpl pokeDeckDao = new PokeDeckDaoImpl();
//	private TradesDaoImpl tradeDao = new TradesDaoImpl();
//	private TeamDaoImpl teamDao = new TeamDaoImpl();
	/*
	 * All data below will be tested against the data returned from the DB to 
	 * determine if the correct values are being presented
	 */
	//All data for the first trainer
	Trainer t1 = new Trainer(800,"johndoe", "pass", "john", "doe"); //id, username, password, firstname, lastname
	PokeDeck pdFor1 = new PokeDeck(700, 800, 600); 				//id, trainers id, pokemon id
	Pokemon pokemon1 = new Pokemon(600, 1, "Something Pokemon", "something-ness"); //id, pokeApi id, poke name, type id
	Team t1Team = new Team(850, 800, 600, 0, 0, 0, 0, 0); 			//id, trainer id, poke id 1-6
	Trades trade = new Trades(300, 800, 801, 600, 601,"Pending");   //id, trainer id who wants request, trainer id who is recieving request, 
																    //pokemon id that belongs to the first trainer, pokemon id that belongs to the seond guy, 
																	//status of the request
	//All the data associated with the second trainer
	Trainer t2 = new Trainer(801,"pokeBlue", "passcode", "Jane", "Doe");
	PokeDeck pdFor2 = new PokeDeck(701, 801, 601);
	Pokemon pokemon2 = new Pokemon(601, 6, "Charizard", "fire");
	Team t2Team = new Team(851, 801, 601, 0, 0, 0, 0, 0);
	Trades secondTrade = new Trades(301, 801, 802, 601, 602, "Denied");
	//All data associated with the third trainer
	Trainer t3 = new Trainer(802, "pokeRed", "pass1234", "Alex", "Bell");
	PokeDeck pdFor3 = new PokeDeck(702, 802, 602);
	Pokemon pokemon3 = new Pokemon(602, 7, "Squirtle", "water");
	Team t3Team = new Team(852, 802, 602, 0, 0, 0, 0, 0);
	//List to be filled for testing purposes
	List<Trainer> listOfTrainers = new ArrayList<Trainer>();
	List<Pokemon> listOfPokemon = new ArrayList<Pokemon>();
	List<PokeDeck> listOfPokeDecks = new ArrayList<PokeDeck>();
	List<Team> listOfTeams = new ArrayList<Team>();
	List<Trades> listOfTrades = new ArrayList<Trades>();
//	@Test
//	public void testInsert() {
//		trainerDao.insertTrainer(t1);
//		trainerDao.insertTrainer(t2);
//		trainerDao.insertTrainer(t3);
//		
//		pokemonDao.insertPokemon(pokemon1);
//		pokemonDao.insertPokemon(pokemon2);
//		pokemonDao.insertPokemon(pokemon3);
//		
//		pokeDeckDao.insertDeck(pdFor1);
//		pokeDeckDao.insertDeck(pdFor2);
//		pokeDeckDao.insertDeck(pdFor3);
//		
//		teamDao.insertTeam(t1Team);
//		teamDao.insertTeam(t2Team);
//		teamDao.insertTeam(t3Team);
//		
//		tradeDao.insertTrades(trade);
//		tradeDao.insertTrades(secondTrade);
//	}
	@Test
	public void testTrainerFindById() {
		Trainer Dbt1 = trainerDao.trainerFindById(800);
		Trainer Dbt2 = trainerDao.trainerFindById(801);
		Trainer Dbt3 = trainerDao.trainerFindById(802);
		assertEquals(t1, Dbt1);
		assertEquals(t2, Dbt2);
		assertEquals(t3, Dbt3);
	}
	@Test
	public void testTrainerFindByUsername() {
		Trainer Dbt1 = trainerDao.selectTrainerByUsername("johndoe");
		Trainer Dbt2 = trainerDao.selectTrainerByUsername("pokeBlue");
		Trainer Dbt3 = trainerDao.selectTrainerByUsername("pokeRed");
		assertEquals(t1, Dbt1);
		assertEquals(t2, Dbt2);
		assertEquals(t3, Dbt3);
	}
	@Test
	public void testTrainerFindAll() {
		listOfTrainers.add(t1);
		listOfTrainers.add(t2);
		listOfTrainers.add(t3);
		List<Trainer> dbList = trainerDao.selectAllTrainers();
		assertEquals(listOfTrainers, dbList);
	}
	@Test
	public void testPokemonFindById() {
		Pokemon DbPoke1 = pokemonDao.FindPokemonById(600);
		Pokemon DbPoke2 = pokemonDao.FindPokemonById(601);
		Pokemon DbPoke3 = pokemonDao.FindPokemonById(602);
		assertEquals(pokemon1, DbPoke1);
		assertEquals(pokemon2, DbPoke2);
		assertEquals(pokemon3, DbPoke3);
	}
	@Test
	public void testPokemonFindAll() {
		listOfPokemon.add(pokemon1);
		listOfPokemon.add(pokemon2);
		listOfPokemon.add(pokemon3);
		List<Pokemon> dbList = pokemonDao.selectAllPokemon();
		assertEquals(listOfPokemon, dbList);
	}
	@Test
	public void testPokeDeckFindById() {
		PokeDeck DbDeck1 = pokeDeckDao.FindDeckById(700);
		PokeDeck DbDeck2 = pokeDeckDao.FindDeckById(701);
		PokeDeck DbDeck3 = pokeDeckDao.FindDeckById(702);
		assertEquals(pdFor1, DbDeck1);
		assertEquals(pdFor2, DbDeck2);
		assertEquals(pdFor3, DbDeck3);
	}
	@Test
	public void testPokeDeckFindAll() {
		listOfPokeDecks.add(pdFor1);
		listOfPokeDecks.add(pdFor2);
		listOfPokeDecks.add(pdFor3);
		List<PokeDeck> dbList = pokeDeckDao.selectAllDecks();
		assertEquals(listOfPokeDecks, dbList);
	}
	@Test
	public void testTeamFindById() {
		Team dbTeam1 = teamDao.teamFindById(850);
		Team dbTeam2 = teamDao.teamFindById(851);
		Team dbTeam3 = teamDao.teamFindById(852);
		assertEquals(t1Team, dbTeam1);
		assertEquals(t2Team, dbTeam2);
		assertEquals(t3Team, dbTeam3);
	}
	@Test
	public void testTeamFindAll() {
		listOfTeams.add(t1Team);
		listOfTeams.add(t2Team);
		listOfTeams.add(t3Team);
		List<Team> dbList = teamDao.selectAllTeams();
		assertEquals(listOfTeams, dbList);
	}
	@Test
	public void testTradesFindById() {
		Trades dbTrade1 = tradeDao.FindTradesById(300);
		Trades dbTrade2 = tradeDao.FindTradesById(301);
		assertEquals(trade, dbTrade1);
		assertEquals(secondTrade, dbTrade2);
	}
	@Test
	public void testTradesFindAll() {
		listOfTrades.add(trade);
		listOfTrades.add(secondTrade);
		List<Trades> dbList = tradeDao.selectAllTrades();
		assertEquals(listOfTrades, dbList);
	}
}