package com.revature.repo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.PokeDeck;
import com.revature.models.Pokemon;
import com.revature.models.Team;
import com.revature.util.HibernateUtil;

public class TeamDao {

	public void insertTeam(Team team) {

		Session ses = HibernateUtil.getSession(); // 1. capture the session

		Transaction tx = ses.beginTransaction(); // 2. Perform an operation on the DB

		ses.save(team); // 3. use the save() session method to perform an insert operation

		tx.commit(); // 4. commit the transaction by utilizing a method from the actual Transaction
						// interface;
	}
	
	public void updateTeam(Team team) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(team);
		tx.commit();
	}
	
	/*
	 * remove team
	 */
	public void deleteTeam(int id) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		Team team = ses.get(Team.class, id);
		ses.delete(team);
		
		tx.commit();
	}

	
}
