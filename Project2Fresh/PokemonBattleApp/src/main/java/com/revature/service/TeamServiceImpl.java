package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Team;
import com.revature.repo.TeamDao;


@Service("TeamServiceService")
public class TeamServiceImpl implements TeamService {

	private Logger logger = Logger.getLogger(TeamServiceImpl.class);
	
	@Autowired
	private TeamDao teamDao;
	
	public TeamServiceImpl() {
		super();
		logger.trace("Injection using Autowired TeamDao in TeamServiceImpl");
	}
	
	@Override
	public boolean insertTeam(Team team) {
		teamDao.insertTeam(team);
		return team.getId()!=0;
	}

	@Override
	public List<Team> selectAllTeams() {
		return teamDao.selectAllTeams();
	}

	@Override
	public void updateTeam(Team team) {
		teamDao.updateTeam(team);
	}

	@Override
	public void deleteTeam(int id) {
		teamDao.deleteTeam(id);
	}

}
