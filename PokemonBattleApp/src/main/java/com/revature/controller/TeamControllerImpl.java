package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Team;
import com.revature.service.TeamService;

public final class TeamControllerImpl implements TeamController {

	private static Logger logger = Logger.getLogger(TeamControllerImpl.class);
	
	@Autowired
	private TeamService teamService;
	
	public TeamControllerImpl() {
		logger.trace("Injection session factory bean, TeamControllerImpl");
	}
	
	@Override
	public void insertTeam(Team team) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTeam(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Team> selectAllTeam() {
		// TODO Auto-generated method stub
		return null;
	}

}
