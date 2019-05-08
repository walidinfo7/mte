package com.wf.mte.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wf.mte.entities.Cashier;


@Repository
public interface ICashierDao  extends JpaRepository<Cashier, Long> {
	 @Query(value="select * from cashier  where state=1",nativeQuery=true)
	 public List<Cashier> findAll();
}
