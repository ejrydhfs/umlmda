package org.umlmda.runtime.naming;

import java.net.URL;

import javax.ejb.Remote;
import javax.sql.DataSource;

@Remote
public interface NamingUtilsEjbRemote
{
   String MAPPED_NAME = "umlmda/test/NamingUtilsEjb";
   void helloRemote();
   
   URL getURL();

   DataSource getDataSource();
}
