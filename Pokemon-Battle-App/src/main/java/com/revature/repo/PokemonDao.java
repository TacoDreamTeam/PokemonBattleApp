package com.revature.repo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Pokemon;
import com.revature.util.HibernateUtil;

public class PokemonDao {
	
	public void insertPokemon(Pokemon pokemon) {
		
		Session ses = HibernateUtil.getSession(); // 1. capture the session
		
		// The Transaction Interface is used for managing ACID complient transactions against the DB
		// Transaction is a mechanism for dispatching SQL statements against the DB
		
		Transaction tx = ses.beginTransaction();  // 2. Perform an operation on the DB
		
		ses.save(pokemon); // 3. use the save() session method to perform an insert operation
		
		tx.commit(); // 4. commit the transaction by utilizing a method from the actual Transaction interface;
	}

}
