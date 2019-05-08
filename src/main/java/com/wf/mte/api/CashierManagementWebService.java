package com.wf.mte.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wf.mte.dto.CashierDto;
import com.wf.mte.services.IcashierServices;

@Controller
public class CashierManagementWebService {

	@Autowired
	IcashierServices cashierServices;
	
	@GetMapping("/api/cashiers")
    @ResponseBody
	public List<CashierDto> getAllCashier(){
		return cashierServices.findAll();
	}
	
}
