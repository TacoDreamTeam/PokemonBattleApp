package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Trades;
import com.revature.repo.TradesDao;


@Service("tradesService")
public class TradesServiceImpl implements TradesService {

	private Logger logger = Logger.getLogger(TradesServiceImpl.class);
	
	@Autowired
	private TradesDao tradesDao;
	
	public TradesServiceImpl() {
		super();
		logger.trace("Injection using Autowired TradesDao in TradesServiceImpl");
	}
	
	@Override
	public boolean insertTrades(Trades trade) {
		tradesDao.insertTrades(trade);
		return trade.getId()!=0;

	}

	@Override
	public boolean updateTrades(Trades trade) {
		tradesDao.updateTrades(trade);
		return trade.equals(tradesDao.FindTradesById(trade.getId()));
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
	public boolean deleteTrades(int id) {
		tradesDao.deleteTrades(id);
		return tradesDao.FindTradesById(id)==null;
	}

}
