package org.umlmda.test.combinedids.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.umlmda.test.combinedids.one2many.persistence.test.C2Test;

import junit.framework.TestCase;

public abstract class AbstractTest extends TestCase {

	protected EntityManager em;
	private static Logger log = Logger.getLogger(AbstractTest.class);
	private static boolean createDropSchema = true;
	
	
	public AbstractTest(String name){
		super(name);
	}

	protected void setUp() {
		Map<String,String> prop = new HashMap<String,String>();
		
		if(createDropSchema){
			createDropSchema = false;
			prop.put("hibernate.hbm2ddl.auto", "create-drop");
			log.info("override property hibernate.hbm2ddl.auto:create-drop");
		}else{
			prop.put("hibernate.hbm2ddl.auto", "validate");
			log.info("override property hibernate.hbm2ddl.auto:validate");
		}
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample",prop);
		em = emf.createEntityManager();

		em.getTransaction().begin();
		assertFalse(em.getTransaction().getRollbackOnly());
        boolean assertsEnabled = false;
        assert assertsEnabled = true; // Intentional side effect!!!
        if (!assertsEnabled){
            throw new RuntimeException("Asserts must be enabled!!!");
        }
	}

	protected void tearDown() {
		em.getTransaction().commit();
	}
	
}
