package com.wf.mte.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.wf.mte.dto.CashierDto;

public interface IcashierServices {
	public List<CashierDto> findAll();
	public CashierDto addCashier (CashierDto cashierDto);
	public CashierDto updateCashier (CashierDto cashierDto);
	public List<CashierDto> findAll(Pageable pageable);
	public CashierDto findCashierById(Long id);
}
