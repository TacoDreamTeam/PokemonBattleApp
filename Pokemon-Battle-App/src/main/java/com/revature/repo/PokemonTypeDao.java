package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.PokeType;
import com.revature.util.HibernateUtil;

public class PokemonTypeDao {

	//Inserting the PokemonTypes into the DB
	public void insert() {
	
		
		List<PokeType> pokemonTypes=new ArrayList<PokeType>();
		
		
		double nl=1; //Normal
		double s=2; //Super effective
		double i=0.5; //Ineffective
		double nt=0.01; //No effecT
				
		                                        //n   fi  wa  gr  el  ic  fi  po  gr  fl  ps  bu  ro  gh  dr  da  st  fa 
		pokemonTypes.add(new PokeType("normal",   nl, nl, nl, nl, nl, nl, nl, nl, nl, nl, nl, nl,  i, nt, nl, nl,  i, nl));
		pokemonTypes.add(new PokeType("fire",     nl, i,   i,  s, nl,  s, nl, nl, nl, nl, nl,  s,  i, nl,  i, nl,  s, nl));
		pokemonTypes.add(new PokeType("water",    nl, s,   i,  i, nl, nl, nl, nl,  s, nl, nl, nl,  s, nl,  i, nl, nl, nl));
		pokemonTypes.add(new PokeType("grass",    nl, i,   s,  i, nl, nl, nl,  i,  s,  i, nl,  i,  s, nl,  i, nl,  i, nl));
		pokemonTypes.add(new PokeType("electric", nl, nl,  s,  i,  i, nl, nl, nl, nt,  s, nl, nl, nl, nl,  i, nl, nl, nl));
		pokemonTypes.add(new PokeType("ice",      nl,  i,  i,  s, nl,  i, nl, nl,  s,  s, nl, nl, nl, nl,  s, nl,  i, nl));
		pokemonTypes.add(new PokeType("fighting",  s, nl, nl, nl, nl,  s, nl,  i, nl,  i,  i,  i,  s, nt, nl,  s,  s,  i));
		pokemonTypes.add(new PokeType("poison",   nl, nl, nl,  s, nl, nl, nl,  i,  i, nl, nl, nl,  i,  i, nl, nl, nt,  s));
		pokemonTypes.add(new PokeType("ground",   nl,  s, nl,  i,  s, nl, nl,  s, nl, nt, nl,  i,  s, nl, nl, nl,  s, nl));
		pokemonTypes.add(new PokeType("flying",   nl, nl, nl,  s,  i, nl,  s, nl, nl, nl, nl,  s,  i, nl, nl, nl,  i, nl));
		pokemonTypes.add(new PokeType("psychic",  nl, nl, nl, nl, nl, nl,  s,  s, nl, nl,  i, nl, nl, nl, nl, nt,  i, nl));
		pokemonTypes.add(new PokeType("bug",      nl,  i, nl,  s, nl, nl,  i,  i, nl,  i,  s, nl, nl,  i, nl,  s,  i,  i));
		pokemonTypes.add(new PokeType("rock",     nl,  s, nl, nl, nl,  s,  i, nl,  i,  s, nl,  s, nl, nl, nl, nl,  i, nl));
		pokemonTypes.add(new PokeType("ghost",    nt, nl, nl, nl, nl, nl, nl, nl, nl, nl,  s, nl, nl,  s, nl,  i, nl, nl));
		pokemonTypes.add(new PokeType("dragon",   nl, nl, nl, nl, nl, nl, nl, nl, nl, nl, nl, nl, nl, nl,  s, nl, i , nt));
		pokemonTypes.add(new PokeType("dark",     nl, nl, nl, nl, nl, nl,  i, nl, nl, nl,  s, nl, nl,  s, nl,  i, nl,  i));
		pokemonTypes.add(new PokeType("steel",    nl,  i,  i, nl,  i,  s, nl, nl, nl, nl, nl, nl,  s, nl, nl, nl,  i,  s));
		pokemonTypes.add(new PokeType("fairy",    nl,  i, nl, nl, nl, nl,  s,  i, nl, nl, nl, nl, nl, nl,  s,  s,  i, nl));
		
		
		//1.) Capture the session
		Session ses=HibernateUtil.getSession();
	
		//2.) Perform an operation on the DB
		//The Transaction Interface is used for managing ACID complient transactions against the DB
		//Transaction is a mechanism for dispatching SQL statements against the DB
		Transaction tx=ses.beginTransaction();
			
		//3.) use the save() session method to perform an insert operation
		for (int j=0; j<pokemonTypes.size(); j++) {
			ses.save(pokemonTypes.get(j));
			//ses.update(pokemonTypes.get(j));
		}

			
		//4.) commit the transaction by utilizing a method from the actual Transaction interface
		tx.commit();
	}
	
}
