package com.wf.mte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wf.mte.dao.ICashierDao;
import com.wf.mte.dto.CashierDto;
import com.wf.mte.entities.Cashier;
import com.wf.mte.utils.MteUtils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

@Service
public class CashierServices implements IcashierServices {

	@Autowired
	private ICashierDao cashierdao;
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<CashierDto> findAll() {

		List<Cashier> listCashier = cashierdao.findAll();
		
		return MteUtils.mapperObject(listCashier,modelMapper);
	}


	@Override
	public CashierDto addCashier(CashierDto cashierDto) {

		Cashier cashier;
		cashier=modelMapper.map(cashierDto,Cashier.class);
		Cashier result = cashierdao.save(cashier);
		BeanUtils.copyProperties(result, cashierDto);
		return cashierDto;
	}


	@Override
	public CashierDto updateCashier(CashierDto cashierDto) {
		Cashier cashier;
		cashier=modelMapper.map(cashierDto,Cashier.class);
		Cashier result = cashierdao.save(cashier);
		BeanUtils.copyProperties(result, cashierDto);
		return cashierDto;
	}

	@Override
	public List<CashierDto> findAll(Pageable pageable) {
		Page<Cashier> listCashier = cashierdao.findAll(pageable);
		return MteUtils.mapperObject(listCashier.getContent(),modelMapper);
	}


	@Override
	public CashierDto findCashierById(Long id) {
		Optional<Cashier> cashier = cashierdao.findCashierById(id);
		if(!cashier.isPresent()){
	       return null;
		}
		return modelMapper.map(cashier.get(),CashierDto.class);
		
	}
	
}
