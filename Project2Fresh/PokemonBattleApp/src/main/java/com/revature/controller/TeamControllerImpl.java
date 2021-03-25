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
import com.revature.models.Team;
import com.revature.service.PokeDeckService;
import com.revature.service.TeamService;


@Controller("teamController")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamControllerImpl implements TeamController {

	private static Logger logger = Logger.getLogger(TeamControllerImpl.class);
	
	@Autowired
	private TeamService teamService;
	
//	public TeamControllerImpl() {
//		logger.trace("Injection session factory bean, TeamControllerImpl");
//	}
	
	
	@PostMapping("/TeamInsert")
	public  @ResponseBody ClientMessage insertTeam(@RequestBody Team team) {
		return(teamService.insertTeam(team)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@GetMapping("/TeamGetAll")
	public List<Team> selectAllTeams() {
		// TODO Auto-generated method stub
		return teamService.selectAllTeams();
	}

	@PostMapping("/TeamUpdate")
	public void updateTeam(@RequestBody Team team) {
		teamService.updateTeam(team);

	}

	@PostMapping("/TeamDelete")
	public void deleteTeam(@RequestBody int id) {
		teamService.deleteTeam(id);

	}

}
