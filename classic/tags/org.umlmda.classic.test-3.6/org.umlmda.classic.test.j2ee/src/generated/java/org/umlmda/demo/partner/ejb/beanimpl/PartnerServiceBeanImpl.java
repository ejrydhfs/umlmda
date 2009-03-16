//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
// $Header$
// $Source$
// $Revision$
// $State$
// $Name$
// $Date$
// $Locker$
//@@UserSection-End RCSHeader
   
package org.umlmda.demo.partner.ejb.beanimpl;

import javax.ejb.SessionContext;
import java.util.logging.*;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.umlmda.demo.common.dto.SecurityToken;
import org.umlmda.demo.common.ejb.beanimpl.CommonServiceBeanImpl;
import org.umlmda.demo.partner.PartnerFactory;
import org.umlmda.demo.partner.PartnerService;
import org.umlmda.demo.partner.dto.Partner;
//@@UserSection-Begin PartnerService.Imports
//@@UserSection-End PartnerService.Imports

/**
 * Bean implementation for PartnerService.
 * @see org.umlmda.demo.partner.PartnerService
 */
public class PartnerServiceBeanImpl extends CommonServiceBeanImpl
{
   private SessionContext sessionContext = null;
   private PartnerService delegate = null;
   private Logger logger = Logger.getLogger(getClass().getName());
   
   /**
    * Set the delegate 
    */
   protected void setDelegate(Object delegate) {
      if ( delegate instanceof PartnerService ) {
         this.delegate = (PartnerService)delegate;
         super.setDelegate(delegate);
      }
      else {
         throw new IllegalArgumentException("delegate not instanceof org.umlmda.demo.partner.PartnerService");
      } 
   }

   /**
    * Reads a partner which  data valid at the given date.
    */
   public Partner read (String id, javax.xml.datatype.XMLGregorianCalendar validityDate, SecurityToken security) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"read"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerService");
         context.startElement("read");
         context.simpleElement("id", id);
         context.simpleElement("validityDate", validityDate);
         if ( security instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)security).marshal("security", context, false);
         context.endElement("read");
         context.endElement("PartnerService");
         logger.log(Level.FINER, context.toString());
      }

      try {
         return delegate.read(id, validityDate, security);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerService");
            context.startElement("read");
            context.simpleElement("id", id);
            context.simpleElement("validityDate", validityDate);
            if ( security instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)security).marshal("security", context, false);
            context.endElement("read");
            context.endElement("PartnerService");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"read"); }
      }
   }

   /**
    * Updates a partner which  data valid for the given date.
    */
   public void update (Partner toUpdate, javax.xml.datatype.XMLGregorianCalendar validityDate) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"update"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerService");
         context.startElement("update");
         if ( toUpdate instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toUpdate).marshal("toUpdate", context, false);
         context.simpleElement("validityDate", validityDate);
         context.endElement("update");
         context.endElement("PartnerService");
         logger.log(Level.FINER, context.toString());
      }

      try {
         delegate.update(toUpdate, validityDate);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerService");
            context.startElement("update");
            if ( toUpdate instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toUpdate).marshal("toUpdate", context, false);
            context.simpleElement("validityDate", validityDate);
            context.endElement("update");
            context.endElement("PartnerService");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"update"); }
      }
   }

   /**
    * 
    */
   public Partner echo (Partner toEcho) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"echo"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerService");
         context.startElement("echo");
         if ( toEcho instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toEcho).marshal("toEcho", context, false);
         context.endElement("echo");
         context.endElement("PartnerService");
         logger.log(Level.FINER, context.toString());
      }

      try {
         return delegate.echo(toEcho);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerService");
            context.startElement("echo");
            if ( toEcho instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toEcho).marshal("toEcho", context, false);
            context.endElement("echo");
            context.endElement("PartnerService");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"echo"); }
      }
   }

   public void onEjbCreate() throws javax.ejb.CreateException {
      PartnerFactory factory;

      factory = (PartnerFactory) getBeanFactory().getBean("PartnerFactory", PartnerFactory.class);
      if ( factory != null ) {
         setDelegate(factory.createPartnerService());
      }
      else {
         String msg = "Unable to create an instance of "+PartnerFactory.class+" from bean factory";
         logger.log(Level.WARNING, msg);
         throw new javax.ejb.CreateException(msg);
      }
//@@UserSection-Begin PartnerService.ejbCreate
//@@UserSection-End PartnerService.ejbCreate      
   }

   /**
    * Get the bean factory and register the bean factory with the name "BeanFactory"
    */ 	   
    protected BeanFactory getBeanFactory() {
      BeanFactory beanFactory = super.getBeanFactory();

      if ( beanFactory.getType("BeanFactory") == null ) {
         register("BeanFactory", beanFactory);
      }
      return beanFactory;
   }
   
   private void register(String contextName, Object singleton) {
      BeanFactory beanFactory = super.getBeanFactory();
      
      if (beanFactory instanceof ConfigurableBeanFactory) {
         ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory)beanFactory;
         
         configurableBeanFactory.registerSingleton(contextName, singleton);
      }
      else if (beanFactory instanceof ConfigurableApplicationContext) {
         ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext)beanFactory;
         
         applicationContext.getBeanFactory().registerSingleton(contextName, singleton);
      }
      else {
         throw new RuntimeException("Unable to regsiter a bean in the beanFactory "+beanFactory.getClass().toString());
      }
   }
   

//@@UserSection-Begin PartnerService.NotModeledElements
//@@UserSection-End PartnerService.NotModeledElements
};
