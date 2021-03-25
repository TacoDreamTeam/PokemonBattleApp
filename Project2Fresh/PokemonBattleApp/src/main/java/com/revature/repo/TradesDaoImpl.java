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
import com.revature.models.Trades;


@Repository("tradesDao")
@Transactional
public class TradesDaoImpl implements TradesDao {

	
	private static Logger logger = Logger.getLogger(TradesDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public TradesDaoImpl() {
		logger.trace("Injection session factory bean");
	}

	@Override
	public void insertTrades(Trades trade) {
		sessionFactory.getCurrentSession().save(trade);
		
	}

	@Override
	public void updateTrades(Trades trade) {
		try {
			sessionFactory.getCurrentSession().update(trade);
		}catch (EntityNotFoundException e){
			System.out.println(e);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trades> selectAllTrades() {
		return sessionFactory.getCurrentSession().createQuery("from Trades").list();
	}

	@Override
	public Trades FindTradesById(int id) {
		try {
			return (Trades) sessionFactory.getCurrentSession().createCriteria(Trades.class).add(Restrictions.like("id", id))
					.list().get(0);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);
			return null;
		}
	}

	@Override
	public void deleteTrades(int id) {
		try {
			Trades trades=(Trades) sessionFactory.getCurrentSession().createCriteria(Trades.class).add(Restrictions.like("id", id))
					.list().get(0);
			sessionFactory.getCurrentSession().delete(trades);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);	
		}
		
	}

	
}
