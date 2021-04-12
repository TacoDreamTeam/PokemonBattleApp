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
		System.out.println("adding the pokemon");
		logger.debug("adding the pokemon");
		sessionFactory.getCurrentSession().save(pokemon);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pokemon> selectAllPokemon() {
		System.out.println("getting all the pokemon");
		logger.debug("getting all the pokemon");
		return sessionFactory.getCurrentSession().createCriteria(Pokemon.class).list();
	}

	@Override
	public Pokemon FindPokemonById(int id) {
		System.out.println("finding the pokemon by id");
		logger.debug("finding the pokemon by id");
		try {
			//return (Pokemon) sessionFactory.getCurrentSession().createCriteria(Pokemon.class).add(Restrictions.like("id", id)).list().get(0);
			return (Pokemon) sessionFactory.getCurrentSession().get(Pokemon.class, id);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);
			return null;
		}
	}

	@Override
	public void updatePokemon(Pokemon pokemon) {
		System.out.println("updating the pokemon");
		logger.debug("updating the pokemon");
		try {
			sessionFactory.getCurrentSession().update(pokemon);
		}catch (EntityNotFoundException e){
			logger.debug(e);
		}
	}
	
	@Override
	public void deletePokemon(int id) {
		System.out.println("deleting the pokemon");
		logger.debug("deleting the pokemon");
		try {
			//Pokemon pokemon=(Pokemon) sessionFactory.getCurrentSession().createCriteria(Pokemon.class).add(Restrictions.like("id", id)).list().get(0);
			Pokemon pokemon=(Pokemon) sessionFactory.getCurrentSession().get(Pokemon.class, id);
			sessionFactory.getCurrentSession().delete(pokemon);
		} catch (IndexOutOfBoundsException e) {
			logger.debug(e);	
		}
		
	}

}
