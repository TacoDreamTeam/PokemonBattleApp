package com.revature.models;

import org.hibernate.Session;

import com.revature.repo.PokeDeckDao;
import com.revature.repo.PokemonDao;
import com.revature.repo.TeamDao;
import com.revature.repo.TrainerDao;
import com.revature.util.HibernateUtil;

/**
 * @author omars
 *
 */
public class Driver {

	public static void main(String[] args) {
		System.out.println("starting session");
		Session ses1=HibernateUtil.getSession();
		
		initTrainer();

		
	}

	public static void initTrainer() {
		
		Trainer t1=new Trainer("johndoe","pass","john","doe");
		TrainerDao tDao= new TrainerDao();
<<<<<<< HEAD
=======
		// It was complaining about needing to create a class for insert(Trainer)
>>>>>>> main
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
		
		
		
		
		
		
		
		
	}
}
