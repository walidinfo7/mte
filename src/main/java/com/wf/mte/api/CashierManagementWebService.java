package com.wf.mte.api;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wf.mte.dto.CashierDto;
import com.wf.mte.services.IcashierServices;

@Controller
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class CashierManagementWebService {

	@Autowired
	IcashierServices cashierServices;
	
	@GetMapping("/api/cashiers")
    @ResponseBody
	public List<CashierDto> getAllCashier(){
		return cashierServices.findAll();
	}
	
	@GetMapping("/api/cashiers/{id}")
    @ResponseBody
	public CashierDto getCashier(@PathVariable Long id){
		return cashierServices.findCashierById(id);
	}
	
	
	@PostMapping("/api/cashiers/add")
	@ResponseBody
	public ResponseEntity<Void> addcashier(@RequestBody CashierDto cashierDto){
		CashierDto result = cashierServices.addCashier(cashierDto);

	        if (result == null)
	            return ResponseEntity.noContent().build();

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(result.getId())
	                .toUri();

	        return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping("/api/cashiers/update")
	@ResponseBody
	public CashierDto updatecashier(@RequestBody CashierDto cashierDto){
		CashierDto result = cashierServices.updateCashier(cashierDto);
		return result;
	}
	
	@GetMapping("/api/cashiers/{from}/{to}")
	@ResponseBody
	  public List<CashierDto> findAll(@PathVariable int from, @PathVariable int to ) {

		List<CashierDto> ret = cashierServices.findAll(PageRequest.of(from, to));
		return ret;
	}
}
