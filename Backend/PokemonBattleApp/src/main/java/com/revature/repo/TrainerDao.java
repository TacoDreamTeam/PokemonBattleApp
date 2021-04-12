package com.revature.repo;

import java.util.List;

import com.revature.models.Trainer;

public interface TrainerDao {

	public void insertTrainer(Trainer trainer);
	
	public List<Trainer> selectAllTrainers();
	
	public Trainer trainerFindById(int id);
	
	public Trainer selectTrainerByUsername(String username);

	public void deleteTrainer(int id);
	
	public void updateTrainer(Trainer trainer);
}
