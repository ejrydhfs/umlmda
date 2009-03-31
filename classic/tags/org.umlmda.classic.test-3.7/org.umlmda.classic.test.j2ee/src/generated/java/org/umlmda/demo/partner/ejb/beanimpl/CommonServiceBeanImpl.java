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
import org.umlmda.demo.partner.CommonService;
import org.umlmda.demo.partner.PartnerFactory;
//@@UserSection-Begin CommonService.Imports
//@@UserSection-End CommonService.Imports

/**
 * Bean implementation for CommonService.
 * @see org.umlmda.demo.partner.CommonService
 */
public class CommonServiceBeanImpl extends org.umlmda.demo.common.ejb.beanimpl.CommonServiceBeanImpl
{
   private SessionContext sessionContext = null;
   private CommonService delegate = null;
   private Logger logger = Logger.getLogger(getClass().getName());
   
   /**
    * Set the delegate 
    */
   protected void setDelegate(Object delegate) {
      if ( delegate instanceof CommonService ) {
         this.delegate = (CommonService)delegate;
         super.setDelegate(delegate);
      }
      else {
         throw new IllegalArgumentException("delegate not instanceof org.umlmda.demo.partner.CommonService");
      } 
   }

   /**
    * 
    */
   public String getVersion () {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"getVersion"); }

      try {
         return delegate.getVersion();
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         
         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"getVersion"); }
      }
   }

   public void onEjbCreate() throws javax.ejb.CreateException {
      PartnerFactory factory;

      factory = (PartnerFactory) getBeanFactory().getBean("PartnerFactory", PartnerFactory.class);
      if ( factory != null ) {
         setDelegate(factory.createCommonService());
      }
      else {
         String msg = "Unable to create an instance of "+PartnerFactory.class+" from bean factory";
         logger.log(Level.WARNING, msg);
         throw new javax.ejb.CreateException(msg);
      }
//@@UserSection-Begin CommonService.ejbCreate
//@@UserSection-End CommonService.ejbCreate      
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
   

//@@UserSection-Begin CommonService.NotModeledElements
//@@UserSection-End CommonService.NotModeledElements
};
