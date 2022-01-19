package com.transactional.demo;

import java.util.HashMap;
import java.util.Map;

import com.transactional.exceptions.InsufficentFundInAccountException;

public class FlightPaymentUtils {
	
	private static Map<String, Double> paymentMap = new HashMap<String, Double>();
	
	static {
		paymentMap.put("accno1", 12000.0);
		paymentMap.put("accno2", 10000.0);
		paymentMap.put("accno3", 5000.0);
		paymentMap.put("accno4", 8000.0);
	}
	
	public static boolean validateCreditLimit(String accountno, double paidamount) {

		if(paidamount > paymentMap.get(accountno)) {
			throw new InsufficentFundInAccountException("Account limit reached, not enough funds to proceed");
		}else
			return true;
		
	}
}
