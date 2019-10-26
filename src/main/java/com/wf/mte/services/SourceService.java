package com.wf.mte.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.mte.dao.ISourceDao;
import com.wf.mte.dto.SourceDto;
import com.wf.mte.entities.Source;
import com.wf.mte.utils.MteUtils;

@Service
public class SourceService implements ISourceService {

	@Autowired
	private ISourceDao sourceDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<SourceDto> findAll() {
		List<Source> sources = sourceDao.findAll();
		return MteUtils.mapperObject(sources, modelMapper);
	}

	@Override
	public SourceDto findSourceById(Long id) {
		Optional<Source> source = sourceDao.findById(id);
		if (!source.isPresent()) {
			return null;
		}
		return modelMapper.map(source.get(), SourceDto.class);
	}

	@Override
	public void deleteSourceById(Long id) {
		sourceDao.deleteById(id);
	}

	@Override
	public SourceDto addSource(SourceDto source) {
		Source newSource = modelMapper.map(source, Source.class);
		newSource = sourceDao.save(newSource);
		BeanUtils.copyProperties(newSource, source);
		return source;
	}

	@Override
	public SourceDto updateSource(SourceDto sourceDto) {
//		Optional<Source> sourceFromDb = sourceDao.findById(source.getId());
//		if (!sourceFromDb.isPresent()) {
//          return null;
//		}
//		
		Source newSource = modelMapper.map(sourceDto, Source.class);
		newSource = sourceDao.save(newSource);
		BeanUtils.copyProperties(newSource, sourceDto);
		return sourceDto;
	}

}
