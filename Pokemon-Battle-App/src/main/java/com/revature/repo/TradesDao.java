package com.revature.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.PokeDeck;
import com.revature.models.Pokemon;
import com.revature.models.Trades;
import com.revature.util.HibernateUtil;

public class TradesDao {
	public void insertTrades(Trades trade) {

		Session ses = HibernateUtil.getSession(); // 1. capture the session

		Transaction tx = ses.beginTransaction(); // 2. Perform an operation on the DB

		ses.save(trade); // 3. use the save() session method to perform an insert operation

		tx.commit(); // 4. commit the transaction by utilizing a method from the actual Transaction
						// interface;
	}
	
	public void updateTrades(Trades trade) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(trade);
		tx.commit();
	}


	/*
	 * Returns all trades 
	 */
	
	public List<Trades> selectAllTrades(){
		Session ses=HibernateUtil.getSession();
		
		List<Trades> tradeList = ses.createQuery("from Trades", Trades.class).list();
		
		return tradeList;		
	}
	
	/*
	 * return trade by id
	 */
	
	public Trades FindTradesById(int id) {
		
		Session ses=HibernateUtil.getSession();
		
		Trades trade=ses.get(Trades.class, id);
		
		return trade;
	}

	/*
	 * remove trade
	 */
	public void deleteTrades(int id) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		Trades trade = ses.get(Trades.class, id);
		ses.delete(trade);
		
		tx.commit();
	}

}
