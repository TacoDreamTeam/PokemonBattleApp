package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.models.Trainer;
import com.revature.service.TrainerService;

@Controller("trainerController")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerControllerImpl implements TrainerController{

	private static Logger logger = Logger.getLogger(TrainerControllerImpl.class);
	
	@Autowired
	private TrainerService trainerService;
	
//	public TrainerControllerImpl() {
//		logger.trace("Injection session factory bean, TrainerControllerImpl");
//	}
	
	
	@PostMapping("/TrainerInsert")
	public @ResponseBody ClientMessage insertTrainer(@RequestBody Trainer trainer) {
		return(trainerService.insertTrainer(trainer)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@GetMapping("/TrainerGetAll")
	public @ResponseBody List<Trainer> selectAllTrainers() {
		return trainerService.selectAllTrainers();
	}

	@PostMapping("/TrainerGetById")
	public @ResponseBody Trainer trainerFindById(@RequestBody int id) {
		return trainerService.trainerFindById(id);
	}

	@PostMapping("/TrainerGetByUsername")
	public @ResponseBody Trainer selectTrainerByUsername(@RequestBody String username) {
		return trainerService.selectTrainerByUsername(username);
	}

	@PostMapping("/TrainerDelete")
	public void deleteTrainer(@RequestBody int id) {
		trainerService.deleteTrainer(id);
	}

	@PostMapping("/TrainerUpdate")
	public void updateTrainer(@RequestBody Trainer trainer) {
		trainerService.updateTrainer(trainer);
	}

	@PostMapping("/Login")
	public @ResponseBody Trainer login(@RequestBody String trainerUsername, String password) {
		return trainerService.login(trainerUsername, password);
	}

}
