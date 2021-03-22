package com.revature.models;

import org.hibernate.Session;

import com.revature.repo.PokeDeckDao;
import com.revature.repo.PokemonDao;
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
		// It was complaining about needing to create a class for insert(Trainer)
		tDao.insertTrainer(t1);
		
		PokeDeck pd= new PokeDeck(1,22);
		
		PokeDeckDao pdDao = new PokeDeckDao();
		
		pdDao.insertDeck(pd);
		
		Pokemon poke=new Pokemon();
		
		PokemonDao pDao = new PokemonDao();
		
		
		
		
		
		
		
	}
}
