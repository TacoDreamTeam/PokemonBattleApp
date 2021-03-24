package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Team;
import com.revature.repo.TeamDao;

@Service("TeamService")
public class TeamServiceImpl implements TeamService {

	private Logger logger = Logger.getLogger(TeamServiceImpl.class);
	
	@Autowired
	private TeamDao teamDao;
	
	public TeamServiceImpl() {
		logger.trace("Injection using Autowired TeamServiceDao in TeamServiceImpl");
	}
	
	@Override
	public void insertTeam(Team team) {
		teamDao.insertTeam(team);//change to boolean 
		//return pokedeck.getId()!=0;
	}

	@Override
	public void updateTeam(Team team) {
		teamDao.updateTeam(team);//change to boolean 
		//return pokedeck.getId()!=0;
	}

	@Override
	public void deleteTeam(int id) {
		teamDao.deleteTeam(id);
	}

	@Override
	public List<Team> selectAllTeam() {
		return teamDao.selectAllTeam();
	}

}
