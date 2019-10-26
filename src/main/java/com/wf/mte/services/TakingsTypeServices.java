package com.wf.mte.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.mte.dao.ITakingTypeDao;
import com.wf.mte.dto.TakingsTypeDto;
import com.wf.mte.entities.TakingsType;
import com.wf.mte.utils.MteUtils;

@Service
public class TakingsTypeServices implements ItakingsTypeSerivices{

	@Autowired
	private ITakingTypeDao takingsTypedao;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<TakingsTypeDto> getAllTakingsTypes() {
		List<TakingsTypeDto> takingsTypeDtos=null;
		takingsTypeDtos = MteUtils.mapperObject(takingsTypedao.findAll(), modelMapper);
		return takingsTypeDtos;
		
	}

	@Override
	public TakingsTypeDto addTakingsTypes(TakingsTypeDto takingsTypeDto) {
		TakingsType takingsType = modelMapper.map(takingsTypeDto, TakingsType.class);
		takingsTypedao.save(takingsType);
		takingsTypeDto= modelMapper.map(takingsType, TakingsTypeDto.class);
	    return  takingsTypeDto;
	}

	@Override
	public void deleteTakingsTypes(Long id) {
		takingsTypedao.deleteById(id);
	}

	@Override
	public TakingsTypeDto updateTakingType(TakingsTypeDto takingsTypeDto) {
		Optional<TakingsType> takingsTypeOption = takingsTypedao.findById(takingsTypeDto.getId());
		if(takingsTypeOption.isPresent()){
			TakingsType takingType = takingsTypeOption.get();
			takingType.setComments(takingsTypeDto.getComments());
			takingType.setLabel(takingsTypeDto.getLabel());
			TakingsType result = takingsTypedao.save(takingType);
			BeanUtils.copyProperties(result, takingsTypeDto);
			return takingsTypeDto;
		}
		return null ;                                                                                                                            
	}

	@Override
	public TakingsTypeDto getTakingsTypeById(Long id) {
		Optional<TakingsType> result = takingsTypedao.findById(id);
		if (!result.isPresent()) {
			return null;
		}
		TakingsType takingsType = result.get();
		TakingsTypeDto takingsTypeDto = new TakingsTypeDto();
		BeanUtils.copyProperties(takingsType, takingsTypeDto);
		return takingsTypeDto;
	}
}
