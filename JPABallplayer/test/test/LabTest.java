package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Ballplayer;

import static org.junit.Assert.*;
public class LabTest {

	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Ballplayer b;
     

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("BallPlayerHomeRuns");
		em = emf.createEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		  em.close();
		  emf.close();
	}

	@Test
	public void test() {
		boolean pass = true;
		assertEquals(pass, true);
	}
	
	@Test
	public void test_ballplayer_mapping() {
		b = em.find(Ballplayer.class, 1);
		assertNotNull(b);
		assertEquals(b.getName(), "test");
	}
	
	@Test
	public void test_another_ballplayer_mapping() {
		b = em.find(Ballplayer.class, 2);
		assertNotNull(b);
		assertEquals(b.getName(), "Giancarlo Stanton");
	}
}
