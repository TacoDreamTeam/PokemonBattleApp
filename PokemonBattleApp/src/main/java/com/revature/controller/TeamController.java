package com.revature.controller;

import java.util.List;

import com.revature.models.Team;

public interface TeamController {

	public void insertTeam(Team team);
	
	public void updateTeam(Team team);
	
	public void deleteTeam(int id);
	
	public List<Team> selectAllTeam();
	
}
