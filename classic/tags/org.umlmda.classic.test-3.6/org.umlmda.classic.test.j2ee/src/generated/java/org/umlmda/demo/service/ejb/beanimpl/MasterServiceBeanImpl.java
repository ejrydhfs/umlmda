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
   
package org.umlmda.demo.service.ejb.beanimpl;

import javax.ejb.SessionContext;
import java.util.logging.*;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.ejb.support.AbstractStatelessSessionBean;
import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.service.MasterService;
import org.umlmda.demo.service.ServiceFactory;
//@@UserSection-Begin MasterService.Imports
//@@UserSection-End MasterService.Imports

/**
 * Bean implementation for MasterService.
 * @see org.umlmda.demo.service.MasterService
 */
public class MasterServiceBeanImpl extends AbstractStatelessSessionBean
{
   private SessionContext sessionContext = null;
   private MasterService delegate = null;
   private Logger logger = Logger.getLogger(getClass().getName());
   
   /**
    * Set the delegate 
    */
   protected void setDelegate(Object delegate) {
      if ( delegate instanceof MasterService ) {
         this.delegate = (MasterService)delegate;
      }
      else {
         throw new IllegalArgumentException("delegate not instanceof org.umlmda.demo.service.MasterService");
      } 
   }

   /**
    * 
    */
   public void verify (Partner toVerify) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"verify"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("MasterService");
         context.startElement("verify");
         if ( toVerify instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toVerify).marshal("toVerify", context, false);
         context.endElement("verify");
         context.endElement("MasterService");
         logger.log(Level.FINER, context.toString());
      }

      try {
         delegate.verify(toVerify);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("MasterService");
            context.startElement("verify");
            if ( toVerify instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toVerify).marshal("toVerify", context, false);
            context.endElement("verify");
            context.endElement("MasterService");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"verify"); }
      }
   }

   public void onEjbCreate() throws javax.ejb.CreateException {
      ServiceFactory factory;

      factory = (ServiceFactory) getBeanFactory().getBean("ServiceFactory", ServiceFactory.class);
      if ( factory != null ) {
         setDelegate(factory.createMasterService());
      }
      else {
         String msg = "Unable to create an instance of "+ServiceFactory.class+" from bean factory";
         logger.log(Level.WARNING, msg);
         throw new javax.ejb.CreateException(msg);
      }
//@@UserSection-Begin MasterService.ejbCreate
//@@UserSection-End MasterService.ejbCreate      
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
   

//@@UserSection-Begin MasterService.NotModeledElements
//@@UserSection-End MasterService.NotModeledElements
};
