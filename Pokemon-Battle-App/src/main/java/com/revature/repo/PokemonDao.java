package com.revature.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Pokemon;
import com.revature.util.HibernateUtil;

public class PokemonDao {
	
	public void insertPokemon(Pokemon pokemon) {

		Session ses = HibernateUtil.getSession(); // 1. capture the session

		Transaction tx = ses.beginTransaction(); // 2. Perform an operation on the DB

		ses.save(pokemon); // 3. use the save() session method to perform an insert operation

		tx.commit(); // 4. commit the transaction by utilizing a method from the actual Transaction
						// interface;
	}

	public void updatePokemon(Pokemon pokemon) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(pokemon);
		tx.commit();
	}

	/*
	 * Returns all pokemon
	 */

	public List<Pokemon> selectAllPokemon() {
		Session ses = HibernateUtil.getSession();

		List<Pokemon> pokemonList = ses.createQuery("from Pokemon", Pokemon.class).list();

		return pokemonList;

	}

	/*
	 * return pokemon by id
	 */

	public Pokemon FindPokemonById(int id) {

		Session ses = HibernateUtil.getSession();

		Pokemon teams = ses.get(Pokemon.class, id);

		return teams;

	}

}
