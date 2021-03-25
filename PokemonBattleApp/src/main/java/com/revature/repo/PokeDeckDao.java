package com.revature.repo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.PokeDeck;
import com.revature.util.HibernateUtil;

public class PokeDeckDao {
	
			public void insertDeck(PokeDeck pokedeck) {
				
				Session ses = HibernateUtil.getSession(); // 1. capture the session
				
				// The Transaction Interface is used for managing ACID complient transactions against the DB
				// Transaction is a mechanism for dispatching SQL statements against the DB
				
				Transaction tx = ses.beginTransaction();  // 2. Perform an operation on the DB
				
				ses.save(pokedeck); // 3. use the save() session method to perform an insert operation
				
				tx.commit(); // 4. commit the transaction by utilizing a method from the actual Transaction interface;
			}
			
			/*
			 * Returns all trainer decks 
			 */
			
			public List<PokeDeck> selectAllDecks(){
				Session ses=HibernateUtil.getSession();
				
				List<PokeDeck> deckList = ses.createQuery("from PokeDeck", PokeDeck.class).list();
				
				return deckList;
				
				
			}
			
			/*
			 * return deck by id
			 */
			
			public PokeDeck FindDeckById(int id) {
				
				Session ses=HibernateUtil.getSession();
				
				PokeDeck decks=ses.get(PokeDeck.class, id);
				
				return decks;
				
			}
			
			/*
			 * update the trainer's Deck
			 */
			public void updateDeck(PokeDeck deck) {
				Session ses = HibernateUtil.getSession();
				Transaction tx = ses.beginTransaction();
				
				ses.update(deck);
				
				tx.commit();
			}
			
			/*
			 * remove pokemon from deck
			 */
			public void deleteDeck(int id) {
				Session ses = HibernateUtil.getSession();
				Transaction tx = ses.beginTransaction();
				
				PokeDeck decks = ses.get(PokeDeck.class, id);
				ses.delete(decks);
				
				tx.commit();
			}
}