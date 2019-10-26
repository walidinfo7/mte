package com.wf.mte.services;

import java.util.List;

import com.wf.mte.dto.TakingsTypeDto;

public interface ItakingsTypeSerivices {

	public List<TakingsTypeDto> getAllTakingsTypes();

	public TakingsTypeDto addTakingsTypes(TakingsTypeDto takingsTypeDto);

	public void deleteTakingsTypes(Long id);

	TakingsTypeDto updateTakingType(TakingsTypeDto takingsTypeDto);

	public TakingsTypeDto getTakingsTypeById(Long id);
}