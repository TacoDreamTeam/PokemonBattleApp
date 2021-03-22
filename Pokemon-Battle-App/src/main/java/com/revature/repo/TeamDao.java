package com.revature.repo;

<<<<<<< HEAD
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

=======
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.PokeDeck;
import com.revature.models.Pokemon;
>>>>>>> main
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
<<<<<<< HEAD

=======
	
>>>>>>> main
	public void updateTeam(Team team) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(team);
		tx.commit();
	}
<<<<<<< HEAD

	/*
	 * Returns all trainer decks
	 */

	public List<Team> selectAllTeam() {
		Session ses = HibernateUtil.getSession();

		List<Team> deckList = ses.createQuery("from team", Team.class).list();

		return deckList;

	}

	/*
	 * return deck by id
	 */

	public Team FindTeamById(int id) {

		Session ses = HibernateUtil.getSession();

		Team teams = ses.get(Team.class, id);

		return teams;

	}

=======
	
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

	
>>>>>>> main
}
