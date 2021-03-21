package com.revature.repo;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.PokeDeck;
import com.revature.util.HibernateUtil;

public class PokeDeckDao {
	
	// we will just create an insert method for Crime
			public void insertDeck(PokeDeck pokedeck) {
				
				Session ses = HibernateUtil.getSession(); // 1. capture the session
				
				// The Transaction Interface is used for managing ACID complient transactions against the DB
				// Transaction is a mechanism for dispatching SQL statements against the DB
				
				Transaction tx = ses.beginTransaction();  // 2. Perform an operation on the DB
				
				ses.save(pokedeck); // 3. use the save() session method to perform an insert operation
				
				tx.commit(); // 4. commit the transaction by utilizing a method from the actual Transaction interface;
			}
			
			
			public void updateDeck(PokeDeck pokedeck) {
				
				Session ses=HibernateUtil.getSession();
				Transaction tx = ses.beginTransaction();
				
				ses.save(pokedeck);
				tx.commit();
			}

}
