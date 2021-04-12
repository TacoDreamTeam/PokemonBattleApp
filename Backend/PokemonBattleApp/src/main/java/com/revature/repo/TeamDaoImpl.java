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
import com.revature.models.Team;


@Repository("teamDao")
@Transactional
public class TeamDaoImpl implements TeamDao {

	
	private static Logger logger = Logger.getLogger(TeamDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public TeamDaoImpl() {
		logger.trace("Injection session factory bean");
	}

	@Override
	public void insertTeam(Team team) {
		logger.debug("adding the team (DAO)");
		System.out.println("adding the team (DAO)");
		sessionFactory.getCurrentSession().save(team);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> selectAllTeams() {
		logger.debug("getting all the team (DAO)");
		System.out.println("getting all the team (DAO)");
		System.out.println();
		return sessionFactory.getCurrentSession().createCriteria(Team.class).list();
	}

	public Team teamFindById(int id) {
		logger.debug("finding the team by id (DAO)");
		System.out.println("finding the team by id (DAO)");
		try {
			//return (Pokemon) sessionFactory.getCurrentSession().createCriteria(Pokemon.class).add(Restrictions.like("id", id)).list().get(0);
			return (Team) sessionFactory.getCurrentSession().get(Team.class, id);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);
			return null;
		}
	}

	@Override
	public void updateTeam(Team team) {
		logger.debug("updating the team (DAO)");
		System.out.println("updating the team (DAO)");
		try {
			sessionFactory.getCurrentSession().update(team);
		}catch (EntityNotFoundException e){
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteTeam(int id) {
		logger.debug("deleting the team (DAO)");
		System.out.println("deleting the team (DAO)");
		try {
			Team team=(Team) sessionFactory.getCurrentSession().get(Team.class, id);
			sessionFactory.getCurrentSession().delete(team);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);	
		}	
	}
	
}
