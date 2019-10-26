package com.wf.mte.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wf.mte.entities.TakingsType;

public interface ITakingTypeDao extends JpaRepository<TakingsType, Long> {

}
