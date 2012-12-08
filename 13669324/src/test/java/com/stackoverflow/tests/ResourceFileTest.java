package com.stackoverflow.tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stackoverflow.tests.config.ApplicationContext;
import com.stackoverflow.tests.domain.ResourceFile;
import com.stackoverflow.tests.repository.ResourceFileRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
@Configurable
public class ResourceFileTest {

    @Autowired
    private ResourceFileRepository repository;

    @Test
    public void testMatch() {
	try {
	    List<ResourceFile> resources = this.repository.getResourceFilesOrderByFavourites();

	    System.out.println(resources);
	} catch (JpaSystemException e) {
	    System.out.println(((java.sql.BatchUpdateException) e
		    .getRootCause()).getNextException());
	}
    }
}
