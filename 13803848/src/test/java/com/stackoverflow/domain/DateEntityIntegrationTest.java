package com.stackoverflow.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.PersistenceTest;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.TransactionMode;
import org.jboss.arquillian.persistence.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@PersistenceTest
public class DateEntityIntegrationTest {
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "DateEntityTest.war")
				.addClass(DateEntity.class)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy our test datasource
				.addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}

	@PersistenceContext(unitName = "StackOverTestPU")
	private EntityManager entityManager;

	@Test
	@Transactional(TransactionMode.COMMIT)
	@Cleanup(phase = TestExecutionPhase.NONE)
	public void testSave() {
		DateEntity dateEntity = new DateEntity();
//		dateEntity.setLastLoginDate(new Date());

		Date date = new Date();
		dateEntity.setLastLoginDate(new Timestamp(date.getTime()));
		
		this.entityManager.persist(dateEntity);

		System.out.println(dateEntity);
	}

}
