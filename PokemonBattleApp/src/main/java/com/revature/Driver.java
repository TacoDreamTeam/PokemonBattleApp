package com.revature;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> origin/omar
import org.hibernate.Session;

import com.revature.models.PokeDeck;
import com.revature.models.Pokemon;
import com.revature.models.Team;
<<<<<<< HEAD
=======
import com.revature.models.Trades;
>>>>>>> origin/omar
import com.revature.models.Trainer;
import com.revature.repo.PokeDeckDao;
import com.revature.repo.PokemonDao;
import com.revature.repo.TeamDao;
<<<<<<< HEAD
import com.revature.repo.TrainerDao;
import com.revature.util.HibernateUtil;

/**
 * @author omars
 *
 */
=======
import com.revature.repo.TradesDao;
import com.revature.repo.TrainerDao;
import com.revature.util.HibernateUtil;

>>>>>>> origin/omar
public class Driver {

	public static void main(String[] args) {
		System.out.println("starting session");
<<<<<<< HEAD
		Session ses1=HibernateUtil.getSession();
		
		initTrainer();
	}

	public static void initTrainer() {
		
		Trainer t1=new Trainer("johndoe","pass","john","doe");
		TrainerDao tDao= new TrainerDao();
		// It was complaining about needing to create a class for insert(Trainer)
		tDao.insertTrainer(t1);
		
		PokeDeck pd= new PokeDeck(1,22);
		PokeDeckDao pdDao = new PokeDeckDao();
		pdDao.insertDeck(pd);
		
		Pokemon poke=new Pokemon(1,"Something Pokemon",2);
		PokemonDao pDao = new PokemonDao();
		pDao.insertPokemon(poke);
		
		Team t=new Team(t1.getTrainerId(),22,33,44,11);
		TeamDao teamDao= new TeamDao();
		teamDao.insertTeam(t);
		
		
		System.out.println(tDao.selectAllTrainers());
		System.out.println(pdDao.selectAllDecks());
		System.out.println(pDao.selectAllPokemon());
		System.out.println(teamDao.selectAllTeam());	
=======
		Session ses1 = HibernateUtil.getSession();

		initTrainer();
	}

	public static void initTrainer() {

		Trainer t1 = new Trainer("johndoe", "pass", "john", "doe");
		TrainerDao tDao = new TrainerDao();
		// It was complaining about needing to create a class for insert(Trainer)
		tDao.insertTrainer(t1);

		List<Trainer> trainer = new ArrayList<Trainer>();

		trainer.add(t1);

		PokeDeck pd = new PokeDeck(1, 22);
		PokeDeckDao pdDao = new PokeDeckDao();
		pdDao.insertDeck(pd);

		List<PokeDeck> pokeDeck = new ArrayList<PokeDeck>();
		pokeDeck.add(pd);

		Pokemon poke = new Pokemon(1, "Pokemon", 2);
		PokemonDao pDao = new PokemonDao();
		pDao.insertPokemon(poke);

		Team t = new Team(t1.getTrainerId(), 22, 33, 44, 11);
		TeamDao teamDao = new TeamDao();
		teamDao.insertTeam(t);
		
		
		Trades trade=new Trades(1,22,1,"Accept");
		TradesDao tradeDao=new TradesDao();
		
		tradeDao.insertTrades(trade);
		
		

		System.out.println(tDao.selectAllTrainers());
		System.out.println(pdDao.selectAllDecks());
		System.out.println(pDao.selectAllPokemon());
		System.out.println(teamDao.selectAllTeams());
>>>>>>> origin/omar
	}

}