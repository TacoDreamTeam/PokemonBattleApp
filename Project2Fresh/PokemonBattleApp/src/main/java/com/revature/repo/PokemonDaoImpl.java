package com.revature.repo;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.PokeDeck;
import com.revature.models.Pokemon;

@Repository("pokemonDao")
@Transactional
public class PokemonDaoImpl implements PokemonDao {

	
	private static Logger logger = Logger.getLogger(PokemonDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PokemonDaoImpl() {
		logger.trace("Injection session factory bean");
	}
	
	@Override
	public void insertPokemon(Pokemon pokemon) {
		sessionFactory.getCurrentSession().save(pokemon);
		
	}

	@Override
	public void updatePokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(pokemon);
		}catch (EntityNotFoundException e){
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pokemon> selectAllPokemon() {
		return sessionFactory.getCurrentSession().createCriteria(Pokemon.class).list();
	}

	@Override
	public Pokemon FindPokemonById(int id) {
		try {
			return (Pokemon) sessionFactory.getCurrentSession().createCriteria(Pokemon.class).add(Restrictions.like("id", id))
					.list().get(0);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);
			return null;
		}
	}

	@Override
	public void deletePokemon(int id) {
		try {
			Pokemon pokemon=(Pokemon) sessionFactory.getCurrentSession().createCriteria(Pokemon.class).add(Restrictions.like("id", id))
					.list().get(0);
			sessionFactory.getCurrentSession().delete(pokemon);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);	
		}
		
	}

}
