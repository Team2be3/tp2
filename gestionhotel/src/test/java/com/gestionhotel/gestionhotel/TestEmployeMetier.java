package com.gestionhotel.gestionhotel;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import gestionhotel.Metier.InterEmployeMetier;
import gestionhotel.entities.Employe;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployeMetier {
	
	private static ClassPathXmlApplicationContext context;
	private static InterEmployeMetier metierEmploye;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metierEmploye= (InterEmployeMetier) context.getBean("metierEmploye");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddEmploye() {
		Employe e=new Employe("taouza", "sheherazade", "F", new Date(), "adresse2", "000002", "mail2@mail");
		metierEmploye.addEmploye(e);
		assertNotNull(e.getIdPersonne());
	}

	/*@Test
	public void testDeleteEmploye() {
		List<Employe> tab1= metierEmploye.getListEmploye();
		metierEmploye.deleteEmploye(1L);
		List<Employe> tab2= metierEmploye.getListEmploye();
		assertTrue(tab1.size()-1==tab2.size());
	}*/

	@Test
	public void testUpdateEmploye() {
		Employe e= metierEmploye.getEmploye(7L);
		e.setNomPersonne("taouza2");
		metierEmploye.updateEmploye(e);
		assertTrue(e.getNomPersonne().equals("taouza2"));
	}

	@Test
	public void testGetEmploye() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListEmploye() {
		List<Employe> tab =metierEmploye.getListEmploye();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListEmpMc() {
		List<Employe> tab =metierEmploye.getListEmpMc("za");
		assertTrue(tab.size()>0);
	}

}
