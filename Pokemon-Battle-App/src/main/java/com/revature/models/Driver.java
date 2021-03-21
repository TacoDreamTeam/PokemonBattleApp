package com.revature.models;

import org.hibernate.Session;

import com.revature.util.HibernateUtil;
import com.revtaure.repo.PokeDeckDao;
import com.revtaure.repo.TrainerDao;

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
		
		tDao.insert(t1);
		
		PokeDeck pd= new PokeDeck(1,22);
		
		PokeDeckDao pdDao = new PokeDeckDao();
		
		pdDao.insertDeck(pd);
		
		Pokemon poke=new Pokemon();
		
		
		
	}
}
