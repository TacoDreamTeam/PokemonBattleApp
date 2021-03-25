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
import com.revature.models.Trainer;


@Repository("trainerDao")
@Transactional
public class TrainerDaoImpl implements TrainerDao {

	private static Logger logger = Logger.getLogger(TrainerDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public TrainerDaoImpl() {
		logger.trace("Injection session factory bean");
	}

	@Override
	public void insertTrainer(Trainer trainer) {
		sessionFactory.getCurrentSession().save(trainer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trainer> selectAllTrainers() {
		return sessionFactory.getCurrentSession().createCriteria(Trainer.class).list();
	}

	@Override
	public Trainer trainerFindById(int id) {
		try {
			return (Trainer) sessionFactory.getCurrentSession().createCriteria(Trainer.class).add(Restrictions.like("id", id))
					.list().get(0);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Trainer selectTrainerByUsername(String username) {
		
		
		//List<Trainer> trainerList =(List<Trainer>) sessionFactory.getCurrentSession().createNativeQuery("Select * from trainer where username='"+username+"'",Trainer.class).list();
		
		List<Trainer> trainerList =sessionFactory.getCurrentSession().createCriteria(Trainer.class).add(Restrictions.like("username", username)).list();
		
		//criteria API
		//create complex queries programatically it only uses OOP
		
		//List<SuperVillain> villList =ses.createCriteria(SuperVillain.class).add(Restrictions.like("name", name)).list();
		
		if(trainerList.size()==0) {
			System.out.println("No trainer found with that name");
		}
		
		return trainerList.get(0);
	}

	@Override
	public void deleteTrainer(int id) {
		try {
			Trainer trainer=(Trainer) sessionFactory.getCurrentSession().createCriteria(Trainer.class).add(Restrictions.like("id", id))
					.list().get(0);
			sessionFactory.getCurrentSession().delete(trainer);
		} catch (IndexOutOfBoundsException e) {
			//logger.debug(e);	
		
		}
	}

	@Override
	public void updateTrainer(Trainer trainer) {
		try {
			sessionFactory.getCurrentSession().update(trainer);
		}catch (EntityNotFoundException e){
			System.out.println(e);
		}
		
		
	}

	
	
}
