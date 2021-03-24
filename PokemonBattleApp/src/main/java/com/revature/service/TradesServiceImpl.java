package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Trades;
import com.revature.repo.TradesDao;

@Service("TradesService")
public class TradesServiceImpl implements TradesService {

	private Logger logger = Logger.getLogger(TradesServiceImpl.class);
	
	@Autowired
	private TradesDao tradesDao;
	
	public TradesServiceImpl() {
		logger.trace("Injection using Autowired TradesServiceDao in TradesServiceImpl");
	}
	
	
	@Override
	public void insertTrades(Trades trade) {
		tradesDao.insertTrades(trade);//change to boolean 
		//return insertTrades.getId()!=0;

	}

	@Override
	public void updateTrades(Trades trade) {
		tradesDao.updateTrades(trade);//change to boolean 
		//return insertTrades.getId()!=0;

	}

	@Override
	public List<Trades> selectAllTrades() {
		return tradesDao.selectAllTrades();
	}

	@Override
	public Trades FindTradesById(int id) {
		return tradesDao.FindTradesById(id);
	}

	@Override
	public void deleteTrades(int id) {
		tradesDao.deleteTrades(id);
	}

}
