package com.gestionhotel.gestionhotel;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import gestionhotel.Metier.InterMetierFacture;
import gestionhotel.entities.Client;
import gestionhotel.entities.Facture;
import gestionhotel.entities.Produit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetierFacture {

	private static ClassPathXmlApplicationContext context;
	private static InterMetierFacture metierFacture;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		metierFacture = (InterMetierFacture) context.getBean("metierFacture");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddFacture() {
		Facture f= new Facture(new Date(), "carteBleu");
		metierFacture.addFacture(f, 1L);
		assertNotNull(f.getIdFacture());
		
	}

	@Test
	public void testUpdateFacture() {
		Facture f= metierFacture.getFacture(1L);
		f.setTypePaiement("paiementModifier");
		metierFacture.updateFacture(f);
		assertTrue(f.getTypePaiement().equals("paiementModifier"));
	
	}

	@Test
	public void testDeleteFacturet() {
		List<Facture> tab1=metierFacture.selectFacture();//2
		metierFacture.deleteFacturet(1L);
		List<Facture> tab2= metierFacture.selectFacture();//1
		assertTrue(tab1.size()-1==tab2.size());
	}

	@Test
	public void testSelectFacture() {
		List<Facture> list = metierFacture.selectFacture();
		assertNotNull(list);
	}

}
