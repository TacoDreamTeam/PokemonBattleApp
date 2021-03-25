package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.PokeType;


@Repository("pokemonTypeDao")
@Transactional
public class PokemonTypeDaoImpl implements PokemonTypeDao {

	private static Logger logger = Logger.getLogger(PokemonTypeDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PokemonTypeDaoImpl() {
		logger.trace("Injection session factory bean");
	}

	@Override
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
		
				
		for (int j=0; j<pokemonTypes.size(); j++) {
			sessionFactory.getCurrentSession().save(pokemonTypes.get(j));
			//ses.update(pokemonTypes.get(j));
		}

		
	}

	@Override
	public double effectivness(String type1, String type2) {
		// TODO Auto-generated method stub
		return(double) sessionFactory.getCurrentSession().createQuery("SELECT t."+type2+" FROM PokeType t WHERE pokemonType='"+type1+"'").uniqueResult();
	}
	
}
