package com.gestionhotel.gestionhotel;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import gestionhotel.Metier.InterReservationMetier;
import gestionhotel.entities.Chambre;
import gestionhotel.entities.Client;
import gestionhotel.entities.Employe;
import gestionhotel.entities.Reservation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testreservation {
	
	private static ClassPathXmlApplicationContext context;
	private static InterReservationMetier metierReservation;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		metierReservation = (InterReservationMetier) context.getBean("metierReservation");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	
	@Test
	public void testAddreservation() throws Exception {
		Reservation r = new Reservation(new Date(), new Date(), "Payé");
		metierReservation.addreservation(r, 1L, 2L);
		assertNotNull(r.getIdReservation());
		
		
	}

	@Test
	public void testDeletereservation() {
		List<Reservation> tab1 = metierReservation.getlistereservations();
		metierReservation.deletereservation(1L);
		List<Reservation> tab2 = metierReservation.getlistereservations();
		assertNotNull(tab1.size()==tab2.size()+1);
	}

	@Test
	public void testUpdatereservation() {
		Reservation r=metierReservation.getreservation(2L);
		r.setEtatReservation("en cours");
		metierReservation.updatereservation(r);
		assertNotNull(r.getEtatReservation().equals("en cours"));
	}

	@Test
	public void testGetreservation() {
		Reservation r=metierReservation.getreservation(1L);
		assertNotNull(r.getIdReservation());
	}

	@Test
	public void testGetlistereservations() {
		List<Reservation> tabr=metierReservation.getlistereservations();
		assertNotNull(tabr.size()>0);
	}

}
