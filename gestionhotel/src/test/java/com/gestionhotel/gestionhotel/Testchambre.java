package com.gestionhotel.gestionhotel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import gestionhotel.Metier.InterChambreMetier;
import gestionhotel.entities.Chambre;
import gestionhotel.entities.Reservation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testchambre {
	
	private static ClassPathXmlApplicationContext context;
	private static InterChambreMetier metierChambre;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		metierChambre = (InterChambreMetier) context.getBean("metierChambre");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddchambre() {
		Chambre c=new Chambre(4L, 3, 200.0, "Etat");
		metierChambre.addchambre(c);
		assertNotNull(c.getIdChambre());
		
	}

	@Test
	public void testDeletechambre() {
		List<Chambre> tab1 = metierChambre.getlistechambres();
		metierChambre.deletechambre(4L);
		List<Chambre> tab2 = metierChambre.getlistechambres();
		assertNotNull(tab1.size()==tab2.size()+1);
	}

	@Test
	public void testUpdatechambre() {
		Chambre c = metierChambre.getChambre(6L);
		c.setDescription("Sale");
		metierChambre.updatechambre(c);
		assertNotNull(c.getDescription().equals("Sale"));
	}

	@Test
	public void testGetChambre() {
		Chambre c = metierChambre.getChambre(6L);
		assertNotNull(c.getIdChambre());
	}

	@Test
	public void testGetlistechambres() {
		List<Chambre> tab = metierChambre.getlistechambres();
		assertNotNull(tab.size()>0);		
	}

	@Test
	public void testGetlistereservchambre() {
		List<Reservation> tabr = metierChambre.getlistereservchambre(1L);
		assertNotNull(tabr.size()>0);
	}

	@Test
	public void testDispochambre() {
		fail("Not yet implemented");
	}

}
