package com.example.interestcalculatorpostgres.service;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.interestcalculatorpostgres.dao.InterestCalculatorDao;
import com.example.interestcalculatorpostgres.dao.HomeLoan;
import com.example.interestcalculatorpostgres.dao.TotalInterest;

@Service
public class InterestCalculatorService {

	private static final Logger logger = java.util.logging.Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Autowired
	private InterestCalculatorDao interestCalculatorDao;

	TotalInterest ti= new TotalInterest();

	public TotalInterest getInterestDetails(HomeLoan hl) {

		try {
			if(hl.getLoanAmount() > 0 && hl.getLoanAmount() < 3000000) {
				hl.setRate(6.5);
				ti.setTotalInterest((hl.getLoanAmount()*hl.getTenure()*hl.getRate())/100);
			}
			else if(hl.getLoanAmount() >= 3100000 && hl.getLoanAmount() < 5000000) {
				hl.setRate(7.5);
				ti.setTotalInterest((hl.getLoanAmount()*hl.getTenure()*hl.getRate())/100);
			}
			else if(hl.getLoanAmount() >= 5000000 && hl.getLoanAmount() < 9000000) {
				hl.setRate(9.0);
				ti.setTotalInterest((hl.getLoanAmount()*hl.getTenure()*hl.getRate())/100);
			}
		}
		catch (IllegalArgumentException e)
		{
			logger.info("Invalid input");
		}
		ti.setTotalAmount(ti.getTotalInterest() + hl.getLoanAmount());
		interestCalculatorDao.save(hl);
		return ti;
	}
	
}
