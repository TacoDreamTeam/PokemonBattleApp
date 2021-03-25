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

@Repository("pokeDeckDao")
@Transactional
public class PokeDeckDaoImpl implements PokeDeckDao {

	private static Logger logger = Logger.getLogger(PokeDeckDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PokeDeckDaoImpl() {
		logger.trace("Injection session factory bean");
	}
	
	@Override
	public void insertDeck(PokeDeck pokedeck) {
		sessionFactory.getCurrentSession().save(pokedeck);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PokeDeck> selectAllDecks() {
		return sessionFactory.getCurrentSession().createCriteria(PokeDeck.class).list();
	}

	@Override
	public PokeDeck FindDeckById(int id) {
		try {
			return (PokeDeck) sessionFactory.getCurrentSession().createCriteria(PokeDeck.class).add(Restrictions.like("id", id))
					.list().get(0);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);
			return null;
		}
	}

	@Override
	public void deleteDeck(int id) {
		try {
			PokeDeck decks=(PokeDeck) sessionFactory.getCurrentSession().createCriteria(PokeDeck.class).add(Restrictions.like("id", id))
					.list().get(0);
			sessionFactory.getCurrentSession().delete(decks);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);	
		}
	}

	@Override
	public void updateDeck(PokeDeck pokedeck) {
		try {
			sessionFactory.getCurrentSession().update(pokedeck);
		}catch (EntityNotFoundException e){
			System.out.println(e);
		}
		
	}

}
