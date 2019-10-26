package com.wf.mte.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.mte.entities.Source;

@Repository
public interface ISourceDao  extends JpaRepository<Source, Long> {

}
