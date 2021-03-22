package com.revature.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Trainer;
import com.revature.util.HibernateUtil;



public class TrainerDao {
	
	// we will just create an insert method for Crime
		public void insertTrainer(Trainer trainer) {
			
			Session ses = HibernateUtil.getSession(); // 1. capture the session
			
			// The Transaction Interface is used for managing ACID complient transactions against the DB
			// Transaction is a mechanism for dispatching SQL statements against the DB
			
			Transaction tx = ses.beginTransaction();  // 2. Perform an operation on the DB
			
			ses.save(trainer); // 3. use the save() session method to perform an insert operation
			
			tx.commit(); // 4. commit the transaction by utilizing a method from the actual Transaction interface;
		}
		
		/*
		 * Returns all trainers 
		 */
		
		public List<Trainer> selectAllTrainers(){
			Session ses=HibernateUtil.getSession();
			
			List<Trainer> trainerList = ses.createQuery("from Trainer", Trainer.class).list();
			
			return trainerList;
			
			
		}
		
		/*
		 * return trainer by id
		 */
		
		public Trainer trainerFindById(int id) {
			
			Session ses=HibernateUtil.getSession();
			
			Trainer trainer=ses.get(Trainer.class, id);
			
			return trainer;
			
		}
		
			//return trainer by username
		
		public Trainer selectTrainerByUsername(String username) {
			
			Session ses=HibernateUtil.getSession();
			
			// There was a misspelling in where
			List<Trainer> trainerList =ses.createNativeQuery("Select * from trainer where username='"+username+"'",Trainer.class).list();
			
			//criteria API
			//create complex queries programatically it only uses OOP
			
			//List<SuperVillain> villList =ses.createCriteria(SuperVillain.class).add(Restrictions.like("name", name)).list();
			
			if(trainerList.size()==0) {
				System.out.println("No trainer found with that name");
			}
			
			return trainerList.get(0);
		}
		
		

}