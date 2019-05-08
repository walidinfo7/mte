package com.wf.mte.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.mte.dao.ICashierDao;
import com.wf.mte.dto.CashierDto;
import com.wf.mte.entities.Cashier;

@Service
public class CashierServices implements IcashierServices {

	@Autowired
	private ICashierDao cashierdao;

	@Override
	public List<CashierDto> findAll() {
		
		List<Cashier> listCashier = cashierdao.findAll();
		List<CashierDto> ret=transCashierToDto(listCashier);
		return ret;
	}

	
	private List<CashierDto> transCashierToDto(List<Cashier> cashiers) {
		List<CashierDto> ret = new ArrayList<>();
		for (Cashier c : cashiers) {
			ret.add(new CashierDto(c));
		}
		return ret;
	}
}
