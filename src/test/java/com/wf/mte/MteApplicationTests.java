package com.wf.mte;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.wf.mte.api.CashierManagementWebService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CashierManagementWebService.class})
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class,DirtiesContextTestExecutionListener.class } )
public class MteApplicationTests {

	@Test
	public void contextLoads() {
		assertEquals("aa", "aa");
	}

}
