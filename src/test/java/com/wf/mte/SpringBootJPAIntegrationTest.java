package com.wf.mte;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wf.mte.dao.ICashierDao;
import com.wf.mte.entities.Cashier;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringBootJPAIntegrationTest {
  
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ICashierDao cashierDao;
  
    @Test
    public void testAddCashier() {
    	Cashier cashier = new Cashier();
    	cashier.setId(new Long(0));
    	cashier.setFirstName("walid");
    	cashier.setLastname("farhat");
    	cashier.setState(1);
        Cashier genericEntity = cashierDao.save(cashier);
        Optional<Cashier> foundEntity = cashierDao.findById(genericEntity.getId());
  
        assertNotNull(foundEntity);
    }
}
