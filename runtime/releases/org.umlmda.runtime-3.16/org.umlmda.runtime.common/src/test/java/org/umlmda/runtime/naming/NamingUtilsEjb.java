package org.umlmda.runtime.naming;

import java.net.URL;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.sql.DataSource;


@Stateless(name="NamingUtilsEjb", mappedName=NamingUtilsEjbRemote.MAPPED_NAME)
public class NamingUtilsEjb implements NamingUtilsEjbLocal, NamingUtilsEjbRemote
{
   public static final String RESOURCE_URL_WS_TEST = "url/ws/test";

   @Resource(mappedName=RESOURCE_URL_WS_TEST)
   URL wsURL;
   
   @Resource(mappedName="jdbc/fja/cor/sample")
   DataSource dataSource;
   
   public void helloWorld() {
      System.out.println("URL="+wsURL);
   }

   public void helloRemote() {
      System.out.println("URL="+wsURL);
   }

   public URL getURL() {
      if ( wsURL == null ) {
         try {
            wsURL = NamingUtils.lookup(URL.class, RESOURCE_URL_WS_TEST);
         }
         catch (NamingException e) {
            throw new RuntimeException(e.getMessage(), e);
         }
      }
      return wsURL;
   }
   
   public DataSource getDataSource() {
      return dataSource;
   }
}
