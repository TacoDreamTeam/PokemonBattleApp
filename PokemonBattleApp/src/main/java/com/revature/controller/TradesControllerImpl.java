package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Trades;
import com.revature.service.TradesService;

public class TradesControllerImpl implements TradesController {

	private static Logger logger = Logger.getLogger(TradesControllerImpl.class);
	
	@Autowired
	private TradesService tradesService;
	
	public TradesControllerImpl() {
		logger.trace("Injection session factory bean, TradesControllerImpl");
	}
	
	@Override
	public void insertTrades(Trades trade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTrades(Trades trade) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Trades> selectAllTrades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trades FindTradesById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTrades(int id) {
		// TODO Auto-generated method stub

	}

}
