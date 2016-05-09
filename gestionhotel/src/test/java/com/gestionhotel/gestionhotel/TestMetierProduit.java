package com.gestionhotel.gestionhotel;

import static org.junit.Assert.*;

import java.util.List;

import gestionhotel.Metier.InterMetierProduit;

import gestionhotel.entities.Produit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetierProduit {

	private static ClassPathXmlApplicationContext context;
	private static InterMetierProduit metierProduit;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		metierProduit = (InterMetierProduit) context.getBean("metierProduit");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddProduit() {
		Produit p = new Produit("litBebe", 25, "lit pour bebe");
		metierProduit.addProduit(p);
		assertNotNull(p.getIdProduit());
	}

/*	@Test
	public void testUpdateProduit() {
		Produit p = metierProduit.getProduit(1L);
		p.setNomProduit("nomProduit_modifier");
		metierProduit.updateProduit(p);
		assertTrue(p.getNomProduit().equals("nomProduit_modifier"));
	}
	@Test
	public void testDeleteProduit() {
		List<Produit> tab1 = metierProduit.selectProduit();// 2
		metierProduit.deleteProduit(1L);
		List<Produit> tab2 = metierProduit.selectProduit();// 1
		assertTrue(tab1.size() - 1 == tab2.size());
	}*/

	@Test
	public void testSelectProduit() {
		List<Produit> list = metierProduit.selectProduit();
		assertNotNull(list);
	}

	@Test
	public void testSelectProduitParMc() {
		List<Produit> listMc = metierProduit.selectProduitParMc("o");
		assertNotNull(listMc);
	}

}
