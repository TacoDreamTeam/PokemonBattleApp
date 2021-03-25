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
		sessionFactory.getCurrentSession().save(team);		
	}


	@Override
	public void updateTeam(Team team) {
		try {
			sessionFactory.getCurrentSession().update(team);
		}catch (EntityNotFoundException e){
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteTeam(int id) {
		try {
			Team team=(Team) sessionFactory.getCurrentSession().createCriteria(Team.class).add(Restrictions.like("id", id))
					.list().get(0);
			sessionFactory.getCurrentSession().delete(team);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);	
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> selectAllTeams() {
		return sessionFactory.getCurrentSession().createQuery("from team").list();

	}

	
}
