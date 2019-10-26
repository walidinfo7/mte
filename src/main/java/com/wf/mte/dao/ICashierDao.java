package com.wf.mte.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wf.mte.entities.Cashier;


@Repository
public interface ICashierDao  extends JpaRepository<Cashier, Long>, PagingAndSortingRepository<Cashier, Long> {
	 @Query(value="select * from cashier  where state=1",nativeQuery=true)
	 public List<Cashier> findAll();
	 
	 //@Query(value="select * from cashier  where id=?",nativeQuery=true)
	 public Optional<Cashier> findCashierById(Long id);
}
