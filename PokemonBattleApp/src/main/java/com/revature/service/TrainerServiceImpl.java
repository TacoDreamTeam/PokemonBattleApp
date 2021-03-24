package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Trainer;
import com.revature.repo.TrainerDao;

@Service("TrainerService")
public class TrainerServiceImpl implements TrainerService {

	private Logger logger = Logger.getLogger(TrainerServiceImpl.class);
	
	@Autowired
	private TrainerDao trainerDao;
	
	public TrainerServiceImpl() {
		logger.trace("Injection using Autowired TrainerServiceDao in TrainerServiceImpl");
	}
	
	@Override
	public void insertTrainer(Trainer trainer) {
		trainerDao.insertTrainer(trainer);//change to boolean 
		//return trainer.getId()!=0;
	}

	@Override
	public List<Trainer> selectAllTrainers() {
		return trainerDao.selectAllTrainers();
	}

	@Override
	public Trainer trainerFindById(int id) {
		return trainerDao.trainerFindById(id);
	}

	@Override
	public Trainer selectTrainerByUsername(String username) {
		return trainerDao.selectTrainerByUsername(username);
	}

	@Override
	public Trainer login(String trainerUsername, String password) {
		Trainer trainer=trainerDao.selectTrainerByUsername(trainerUsername);
		if (trainer!=null && trainer.getPassword().equals(password)){
			return trainer;
		}else {
			return null;
		}
	}

}
