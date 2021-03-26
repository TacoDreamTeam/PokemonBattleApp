package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Trainer;
import com.revature.repo.TrainerDao;


@Service("trainerService")
public class TrainerServiceImpl implements TrainerService {

	private Logger logger = Logger.getLogger(TrainerServiceImpl.class);
	
	@Autowired
	private TrainerDao trainerDao;
	
	public TrainerServiceImpl() {
		super();
		logger.trace("Injection using Autowired TrainerDao in TrainerServiceImpl");
	}
	
	@Override
	public boolean insertTrainer(Trainer trainer) {
		trainerDao.insertTrainer(trainer);
		return trainer.getTrainerId()!=0;
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
	public boolean deleteTrainer(int id) {
		trainerDao.deleteTrainer(id);
		return trainerDao.trainerFindById(id)==null;
	}

	@Override
	public boolean updateTrainer(Trainer trainer) {
		trainerDao.updateTrainer(trainer);
		return trainer.equals(trainerDao.trainerFindById(trainer.getTrainerId()));
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
