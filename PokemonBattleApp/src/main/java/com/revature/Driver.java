package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.models.PokeDeck;
import com.revature.models.Pokemon;
import com.revature.models.Team;
import com.revature.models.Trades;
import com.revature.models.Trainer;
import com.revature.repo.PokeDeckDao;
import com.revature.repo.PokemonDao;
import com.revature.repo.TeamDao;
import com.revature.repo.TradesDao;
import com.revature.repo.TrainerDao;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		System.out.println("starting session");
		Session ses1 = HibernateUtil.getSession();

		initTrainer();
	}

	public static void initTrainer() {
		
		
		
		
		Trainer t1 = new Trainer(1,"johndoe", "pass", "john", "doe");
		TrainerDao tDao = new TrainerDao();
		tDao.insertTrainer(t1);
		List<Trainer> trainer = new ArrayList<Trainer>();
		trainer.add(t1);
		
		PokeDeck pdFort1 = new PokeDeck(2,1, 22);
		PokeDeckDao deckDao = new PokeDeckDao();
		deckDao.insertDeck(pdFort1);
		
		Pokemon pokemon1 = new Pokemon(3, 1, "Something Pokemon", "something-ness");
		PokemonDao pDao = new PokemonDao();
		pDao.insertPokemon(pokemon1);
		
		Team t1Team = new Team(1, 1, 22, 33, 44, 11);
		TeamDao teamDao = new TeamDao();
		teamDao.insertTeam(t1Team);
		
		
		Trades trade = new Trades(5, 1,22,1,"Accept");
		TradesDao tradeDao=new TradesDao();
		tradeDao.insertTrades(trade);
		
		Trainer t2 = new Trainer("pokeBlue", "passcode", "Jane", "Doe");
		PokeDeck pdFor2 = new PokeDeck(2, 23);
		Pokemon pokemon2 = new Pokemon(2, "Charzard", "fire");
		Team t2Team = new Team(2, 23, 45, 77);
		Trades secondTrade = new Trades(2, 77, 44, "Denied");
		
		Trainer t3 = new Trainer("pokeRed", "pass1234", "Alex", "Bell");
		PokeDeck pdFor3 = new PokeDeck(3, 13);
		Pokemon pokemon3 = new Pokemon(3, "Squirtle", "water");
		Team t3Team = new Team(3, 55, 21, 89, 120, 20);
		


	}

}