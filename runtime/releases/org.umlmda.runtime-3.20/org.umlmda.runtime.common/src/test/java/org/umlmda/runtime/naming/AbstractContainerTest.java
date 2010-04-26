package org.umlmda.runtime.naming;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class AbstractContainerTest
{
   private static final String OPENEJB_INITIAL_CONTEXT_FACTORY = "org.apache.openejb.client.LocalInitialContextFactory";
   private static final String TESTDS_PROPERTIES = "/testds.properties";
   private boolean setupDone;
   private Logger logger = Logger.getLogger(getClass());

   /**
    * Setups the container. Runs only one time, even if called subsequently.  
    */
   @BeforeClass(alwaysRun=true)
   public void setup() throws Exception {
      
      if ( !setupDone  ) {
         logger.info("Setup container");

         // Check for remote container
         InputStream jndiPropertiesStream = getClass().getResourceAsStream("/jndi.properties");
         if ( jndiPropertiesStream != null ) {
            Properties properties = new Properties();
            
            properties.load(jndiPropertiesStream);
            
            String initialContextFactory = properties.getProperty(Context.INITIAL_CONTEXT_FACTORY);
            if ( StringUtils.isNotEmpty(initialContextFactory)) {
               logger.info("Use initial context from "+initialContextFactory);
            }
            else {
               throw new IllegalStateException(jndiPropertiesStream.toString()+" doesn't contain a "+Context.INITIAL_CONTEXT_FACTORY+" entry");
            }
         }
         else {
            Properties properties = new Properties();
            InputStream dsPropertiesStream = getClass().getResourceAsStream(TESTDS_PROPERTIES);
            
            if ( dsPropertiesStream != null ) {
               URL dsPropertiesURL = getClass().getResource(TESTDS_PROPERTIES);

               logger.info("Loading datasource information from "+dsPropertiesURL.toURI());
               
               properties.load(dsPropertiesStream);
               
            }
            
            // Startup openEJB
            if ( Class.forName(OPENEJB_INITIAL_CONTEXT_FACTORY) != null ) {
               properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, OPENEJB_INITIAL_CONTEXT_FACTORY);
               @SuppressWarnings("unused")
               Context initialContext = new InitialContext(properties);
               System.setProperty(Context.INITIAL_CONTEXT_FACTORY, OPENEJB_INITIAL_CONTEXT_FACTORY);
            }
         }
         setupDone = true;
      }
   }

}
