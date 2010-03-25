package org.umlmda.runtime.naming;

import java.net.MalformedURLException;
import java.net.URL;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

@Test
public class NamingUtilsTest extends AbstractContainerTest
{
   private static final String TEST_URL = "http://www.google.de";
   protected Logger logger = Logger.getLogger(getClass());

   @Test
   public void writeToGlobalnamespace() throws NamingException, MalformedURLException {
      System.out.println("Hello World");
      
      Context context = new InitialContext();
      
      NamingUtils.bind(context, NamingUtilsEjb.RESOURCE_URL_WS_TEST, new URL(TEST_URL));
      NamingUtils.dumpGlobalNamespace(logger, Level.INFO);
   }

   @Test(dependsOnMethods="writeToGlobalnamespace")
   public void readFromGlobalnamespace() throws NamingException, MalformedURLException {
      URL wsURL = NamingUtils.lookup(URL.class, NamingUtilsEjb.RESOURCE_URL_WS_TEST);
      assert wsURL != null;
      assert wsURL.toString().equals(TEST_URL);
   }

   @Test(dependsOnMethods="writeToGlobalnamespace")
   public void readFromEJBNamespace() throws NamingException, MalformedURLException {
      Context context = new InitialContext();
      NamingUtilsEjbRemote ejbRemote = (NamingUtilsEjbRemote) context.lookup(NamingUtilsEjbRemote.MAPPED_NAME);

      assert ejbRemote.getURL() != null : "got ws URL";
      assert ejbRemote.getURL().toString().equals(TEST_URL);
   }

}
