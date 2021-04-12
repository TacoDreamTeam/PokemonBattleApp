package com.revature.repo;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		System.out.println("adding the trade");
		logger.debug("adding the trade");
		sessionFactory.getCurrentSession().save(trade);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trades> selectAllTrades() {
		System.out.println("getting all the trade");
		logger.debug("getting all the trade");
		return sessionFactory.getCurrentSession().createCriteria(Trades.class).list();
	}

	@Override
	public Trades FindTradesById(int id) {
		System.out.println("finding the trade by id");
		logger.debug("finding the trade by id");
		try {
			//return (Trades) sessionFactory.getCurrentSession().createCriteria(Trades.class).add(Restrictions.like("id", id)).list().get(0);
			return (Trades) sessionFactory.getCurrentSession().get(Trades.class, id);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);
			return null;
		}
	}
	
	@Override
	public void updateTrades(Trades trade) {
		System.out.println("updating the trade");
		logger.debug("updating the trade");
		try {
			sessionFactory.getCurrentSession().update(trade);
		}catch (EntityNotFoundException e){
			System.out.println(e);
		}	
	}
	
	@Override
	public void deleteTrades(int id) {
		System.out.println("deleting the trade");
		logger.debug("deleting the trade");
		try {
			//Trades trades=(Trades) sessionFactory.getCurrentSession().createCriteria(Trades.class).add(Restrictions.like("id", id)).list().get(0);
			Trades trades=(Trades) sessionFactory.getCurrentSession().get(Trades.class, id);
			sessionFactory.getCurrentSession().delete(trades);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);	
		}
		
	}

	
}
