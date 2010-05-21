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
   private static final String TEST1_URL = "http://www.google.de";
   private static final String TEST2_URL = "http://www.google.com";
   protected Logger logger = Logger.getLogger(getClass());

   @Test
   public void writeToGlobalnamespace() throws NamingException, MalformedURLException {
      System.out.println("Hello World");
      
      Context context = new InitialContext();
      
      NamingUtils.bind(context, NamingUtilsEjb.RESOURCE_URL_WS_TEST1, new URL(TEST1_URL));
      NamingUtils.bind(context, NamingUtilsEjb.RESOURCE_URL_WS_TEST2, new URL(TEST2_URL));
      NamingUtils.dumpGlobalNamespace(logger, Level.INFO);
   }

   @Test(dependsOnMethods="writeToGlobalnamespace")
   public void readFromGlobalnamespace() throws NamingException, MalformedURLException {
      URL wsURL1 = NamingUtils.lookup(URL.class, NamingUtilsEjb.RESOURCE_URL_WS_TEST1);
      URL wsURL2 = NamingUtils.lookup(URL.class, NamingUtilsEjb.RESOURCE_URL_WS_TEST2);
      
      assert wsURL1 != null;
      assert wsURL1.toString().equals(TEST1_URL);
      assert wsURL2 != null;
      assert wsURL2.toString().equals(TEST2_URL);
   }

   @Test(dependsOnMethods="writeToGlobalnamespace")
   public void readFromEJBNamespace() throws NamingException, MalformedURLException {
      Context context = new InitialContext();
      NamingUtilsEjbRemote ejbRemote = (NamingUtilsEjbRemote) context.lookup(NamingUtilsEjbRemote.MAPPED_NAME);

      assert ejbRemote.getURL() != null : "got ws URL";
      assert ejbRemote.getURL().toString().equals(TEST1_URL);
   }

}
