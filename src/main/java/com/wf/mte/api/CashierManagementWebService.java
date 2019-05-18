package com.wf.mte.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/api/cashiers/add")
	@ResponseBody
	public CashierDto addcashier(@RequestBody CashierDto cashierDto){
		CashierDto result = cashierServices.addCashier(cashierDto);
		return cashierDto;
	}
}
