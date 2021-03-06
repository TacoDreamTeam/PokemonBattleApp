package com.revature.service;

import java.util.List;

import com.revature.models.Trainer;

public interface TrainerService {

	public boolean insertTrainer(Trainer trainer);
	
	public List<Trainer> selectAllTrainers();
	
	public Trainer trainerFindById(int id);
	
	public Trainer selectTrainerByUsername(String username);

	public boolean deleteTrainer(int id);
	
	public boolean updateTrainer(Trainer trainer);
	
	public Trainer login(String trainerUsername, String password);
	
}
