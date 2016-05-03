package com.gestionhotel.gestionhotel;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import gestionhotel.Metier.InterClientMetier;
import gestionhotel.entities.Client;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClientMetier {
	
	private static ClassPathXmlApplicationContext context;
	private static InterClientMetier metierClient;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metierClient= (InterClientMetier) context.getBean("metierClient");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}


	@Test
	public void testAddClient() {
		Client c=new Client("dubuc", "jeremy", "M", new Date(), "adresse1", "00001", "mail@mail");
		metierClient.addClient(c);
		assertNotNull(c.getIdPersonne());
	}

	@Test
	public void testDeleteClient() {
		List<Client> tab1=metierClient.getListClient();//2
		metierClient.deleteClient(1L);
		List<Client> tab2= metierClient.getListClient();//1
		assertTrue(tab1.size()-1==tab2.size());
	}

	@Test
	public void testUpdateClient() {
		Client c=metierClient.getClient(1L);
		c.setNomPersonne("dubuc2");
		metierClient.updateClient(c);
		assertTrue(c.getNomPersonne().equals("dubuc2"));
	}

	@Test
	public void testGetClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListClient() {
		List<Client> tab=metierClient.getListClient();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListCliMc() {
		List<Client> tab=metierClient.getListCliMc("du");
		assertTrue(tab.size()>0);
	}

}
