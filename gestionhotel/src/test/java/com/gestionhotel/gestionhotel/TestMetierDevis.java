package com.gestionhotel.gestionhotel;

import static org.junit.Assert.*;
import intiformation.javajee.lynx.entity.Compte;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import gestionhotel.Metier.InterMetierDevis;
import gestionhotel.entities.Devis;







import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetierDevis {

	private static ClassPathXmlApplicationContext context;
	private static InterMetierDevis metierDevis;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		metierDevis = (InterMetierDevis) context.getBean("metierDevis");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddDevis() {
	 Devis d= new Devis();
	 d.getReservation();
	 metierDevis.addDevis(d, 1L);
	 assertNotNull(d.getIdDevis());
	}

	@Test
	public void testUpdateDevis() {
		Devis d = metierDevis.getDevis(1L);
		d.setIdDevis(1L);
		assertTrue(d.getIdDevis().equals("idModifier"));

	}

	@Test
	public void testDeleteDevis() {
		
		List<Devis> tab1 = metierDevis.selectDevis();
		metierDevis.deleteDevis(1L);
		List<Devis> tab2 =metierDevis.selectDevis();
		assertTrue(tab1.size() - 1 == tab2.size());
	}

	@Test
	public void testAddProduitToDevis() {
		metierDevis.addProduitToDevis(1L, 1L);
		assertTrue(true);;
	}

	@Test
	public void testSelectDevis() {
		List<Devis> list = metierDevis.selectDevis();
		assertNotNull(list);
	}

	@Test
	public void testPrixDevis() {
		metierDevis.prixDevis(1L);
	}

}
