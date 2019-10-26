package com.wf.mte.services;

import java.util.List;

import com.wf.mte.dto.SourceDto;

public interface ISourceService {
    public List<SourceDto> findAll();
    public SourceDto findSourceById(Long id);
    public void deleteSourceById(Long id);
    public SourceDto addSource(SourceDto source);
    public SourceDto updateSource(SourceDto source);

}
