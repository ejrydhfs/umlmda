package org.umlmda.runtime.naming;

import java.util.StringTokenizer;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Utilities to simplify the handling of the jndi in different container implementations.
 * 
 * @author Dieter Moroff
 */
public class NamingUtils
{
   public static Logger logger = Logger.getLogger(NamingUtils.class);
   public static final String OPENEJB_GLOBAL_NAMESPACE_PREFIX = "openejb:";
   private static String globalNamespacePrefix = null;
   
   private static String getGlobalNamespacePrefix() {
      try {
         if ( globalNamespacePrefix == null ) {
            Context context = new InitialContext();
            // Check for openejb
            try {
               NamingEnumeration<Binding> openEjbBindings = context.listBindings(OPENEJB_GLOBAL_NAMESPACE_PREFIX);
               if ( openEjbBindings != null && openEjbBindings.hasMoreElements() ) {
                  globalNamespacePrefix = OPENEJB_GLOBAL_NAMESPACE_PREFIX;

                  logger.debug("Global namespace prefix is :\"" + globalNamespacePrefix + "\"");
               }
               // TODO Check for other container specific prefixes
               else {
                  globalNamespacePrefix = "";
               }
            }
            catch (NameNotFoundException e) {
               // ok not an openejb container
            }
         }
         return globalNamespacePrefix;
      }
      catch (NamingException e) {
         throw new RuntimeException("Error creating NamingUtils", e);
      }
   }

   /**
    * Binds an object in the global naming context, creates all required subcontexts
    * 
    * @param context
    * @param fullname
    * @param object
    * @throws NamingException
    */
   public static void bind(Context context, String fullname, Object object) throws NamingException {
      StringTokenizer nameTokenizer = new StringTokenizer(fullname, "/");
      StringBuffer contextEntryBuffer = new StringBuffer();
      
      do {
         String token = nameTokenizer.nextToken();
         
         if ( contextEntryBuffer.length() > 0 ) {
            contextEntryBuffer.append("/");
         }
         contextEntryBuffer.append(token);

         String contextEntry = contextEntryBuffer.toString();
         
         // Lookup or create subcontext
         if ( nameTokenizer.hasMoreTokens()) {
          
            try {
               context.lookup(contextEntry);
            }
            catch ( NameNotFoundException e ) {
               context.createSubcontext(contextEntry);
            }
         }
         
         // Create binding
         else {
            context.bind(contextEntry, object);
         }
      } while( nameTokenizer.hasMoreTokens() );
   }
   
   /**
    * Type safe lookup in jdni.
    *  
    * @param <T>
    * @param clazz
    * @param name
    * @return
    * @throws NamingException 
    */
   @SuppressWarnings("unchecked")
   public static <T> T lookup(Class<T> clazz, String name) throws NamingException {
      Context context = new InitialContext();
      
      Object object = context.lookup(getGlobalNamespacePrefix()+name);
      
      if ( clazz.isAssignableFrom(clazz) ) {
         return (T)object;
      }
      else {
         throw new IllegalArgumentException("Class "+object.getClass()+" not compatible with "+clazz);
      }
   }
   
   /**
    * Dumps global namespace to logger.
    * 
    * @param logger
    * @param logLevel
    */
   public static void dumpGlobalNamespace(Logger logger, Level logLevel) {
      dumpNamespace(logger, logLevel, getGlobalNamespacePrefix(), null);
   }

   public static void dumpNamespace(Logger logger, Level logLevel, String name) {
      dumpNamespace(logger, logLevel, getGlobalNamespacePrefix(), name);
   }   
   
   private static void dumpNamespace(Logger logger, Level logLevel, String name, String namespacePrefix) {
      try {
         dumpNamespace(logger, logLevel, name, namespacePrefix, new InitialContext());
      }
      catch (NamingException e) {
         throw new RuntimeException(e);
      }
   }
   
   private static void dumpNamespace(Logger logger, Level logLevel, String name, String prefix, Context context) throws NamingException {
      String prefixInNameSpace = StringUtils.isNotEmpty(prefix) ? (prefix + "/" + name) : name;
      NamingEnumeration<Binding> iEntries = context.listBindings(prefixInNameSpace);

      while (iEntries != null && iEntries.hasMore() ) {
         Binding binding = iEntries.next();
         String nameInNampeSpace = prefixInNameSpace + "/" + binding.getName();
         
         logger.log(logLevel, "["+nameInNampeSpace+"]: "+binding.toString());
         if ( binding.getObject() instanceof Context ) {
            dumpNamespace(logger, logLevel, binding.getName(), prefixInNameSpace, (Context) binding.getObject());
         }
      }
   }
   
}
