package org.umlmda.runtime.naming;

import java.net.URL;

import javax.ejb.Remote;
import javax.sql.DataSource;

@Remote
public interface NamingUtilsEjbRemote
{
   public static String MAPPED_NAME = "umlmda/test/NamingUtilsEjb";
   void helloRemote();
   
   URL getURL();

   public DataSource getDataSource();
}
