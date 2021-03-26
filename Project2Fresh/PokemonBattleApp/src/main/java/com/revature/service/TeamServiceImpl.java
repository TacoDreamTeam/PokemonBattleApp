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
		logger.debug("adding the team (service)");
		System.out.println("adding the team (service)");
		teamDao.insertTeam(team);
		return team.getId()!=0;
	}

	@Override
	public List<Team> selectAllTeams() {
		logger.debug("getting all the team (service)");
		System.out.println("getting all the team (service)");
		return teamDao.selectAllTeams();
	}

	@Override
	public Team FindTeamById(int id) {
		logger.debug("finding the team by id (service)");
		System.out.println("finding the team by id (service)");
		return teamDao.teamFindById(id);
	}
	
	@Override
	public boolean updateTeam(Team team) {
		logger.debug("updating the team (service)");
		System.out.println("updating the team (service)");
		teamDao.updateTeam(team);
		return team.equals(teamDao.teamFindById(team.getId()));
	}

	@Override
	public boolean deleteTeam(int id) {
		logger.debug("deleting the team (service)");
		System.out.println("deleting the team (service)");
		teamDao.deleteTeam(id);
		return teamDao.teamFindById(id)==null;
	}

}
