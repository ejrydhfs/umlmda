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
import org.springframework.ejb.support.AbstractStatelessSessionBean;
import org.umlmda.demo.partner.PartnerFactory;
import org.umlmda.demo.partner.PartnerPersistence;
import org.umlmda.demo.partner.dto.Mandator;
import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.partner.dto.PersonList;
//@@UserSection-Begin PartnerPersistence.Imports
//@@UserSection-End PartnerPersistence.Imports

/**
 * Bean implementation for PartnerPersistence.
 * @see org.umlmda.demo.partner.PartnerPersistence
 */
public class PartnerPersistenceBeanImpl extends AbstractStatelessSessionBean
{
   private SessionContext sessionContext = null;
   private PartnerPersistence delegate = null;
   private Logger logger = Logger.getLogger(getClass().getName());
   
   /**
    * Set the delegate 
    */
   protected void setDelegate(Object delegate) {
      if ( delegate instanceof PartnerPersistence ) {
         this.delegate = (PartnerPersistence)delegate;
      }
      else {
         throw new IllegalArgumentException("delegate not instanceof org.umlmda.demo.partner.PartnerPersistence");
      } 
   }

   /**
    * Retrieves all person, which are contact persons in a legal entity.
    */
   public PersonList queryContactPersons () {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"queryContactPersons"); }

      try {
         return delegate.queryContactPersons();
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         
         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"queryContactPersons"); }
      }
   }

   /**
    * null
    */
   public boolean isContainerManaged () {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"isContainerManaged"); }

      try {
         return delegate.isContainerManaged();
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         
         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"isContainerManaged"); }
      }
   }

   /**
    * null
    */
   public Mandator readByPKey_mandator () {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"readByPKey_mandator"); }

      try {
         return delegate.readByPKey_mandator();
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         
         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"readByPKey_mandator"); }
      }
   }

   /**
    * null
    */
   public Mandator deleteByPKey_mandator () {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"deleteByPKey_mandator"); }

      try {
         return delegate.deleteByPKey_mandator();
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         
         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"deleteByPKey_mandator"); }
      }
   }

   /**
    * null
    */
   public void insert_mandator (Mandator toInsert) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"insert_mandator"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerPersistence");
         context.startElement("insert_mandator");
         if ( toInsert instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toInsert).marshal("toInsert", context, false);
         context.endElement("insert_mandator");
         context.endElement("PartnerPersistence");
         logger.log(Level.FINER, context.toString());
      }

      try {
         delegate.insert_mandator(toInsert);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerPersistence");
            context.startElement("insert_mandator");
            if ( toInsert instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toInsert).marshal("toInsert", context, false);
            context.endElement("insert_mandator");
            context.endElement("PartnerPersistence");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"insert_mandator"); }
      }
   }

   /**
    * null
    */
   public void update_mandator (Mandator toUpdate) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"update_mandator"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerPersistence");
         context.startElement("update_mandator");
         if ( toUpdate instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toUpdate).marshal("toUpdate", context, false);
         context.endElement("update_mandator");
         context.endElement("PartnerPersistence");
         logger.log(Level.FINER, context.toString());
      }

      try {
         delegate.update_mandator(toUpdate);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerPersistence");
            context.startElement("update_mandator");
            if ( toUpdate instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toUpdate).marshal("toUpdate", context, false);
            context.endElement("update_mandator");
            context.endElement("PartnerPersistence");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"update_mandator"); }
      }
   }

   /**
    * null
    */
   public void delete_mandator (Mandator toDelete) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"delete_mandator"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerPersistence");
         context.startElement("delete_mandator");
         if ( toDelete instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toDelete).marshal("toDelete", context, false);
         context.endElement("delete_mandator");
         context.endElement("PartnerPersistence");
         logger.log(Level.FINER, context.toString());
      }

      try {
         delegate.delete_mandator(toDelete);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerPersistence");
            context.startElement("delete_mandator");
            if ( toDelete instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toDelete).marshal("toDelete", context, false);
            context.endElement("delete_mandator");
            context.endElement("PartnerPersistence");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"delete_mandator"); }
      }
   }

   /**
    * null
    */
   public void save_mandator (Mandator toSave) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"save_mandator"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerPersistence");
         context.startElement("save_mandator");
         if ( toSave instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toSave).marshal("toSave", context, false);
         context.endElement("save_mandator");
         context.endElement("PartnerPersistence");
         logger.log(Level.FINER, context.toString());
      }

      try {
         delegate.save_mandator(toSave);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerPersistence");
            context.startElement("save_mandator");
            if ( toSave instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toSave).marshal("toSave", context, false);
            context.endElement("save_mandator");
            context.endElement("PartnerPersistence");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"save_mandator"); }
      }
   }

   /**
    * null
    */
   public Partner readByPKeyPartner () {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"readByPKeyPartner"); }

      try {
         return delegate.readByPKeyPartner();
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         
         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"readByPKeyPartner"); }
      }
   }

   /**
    * null
    */
   public Partner deleteByPKeyPartner () {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"deleteByPKeyPartner"); }

      try {
         return delegate.deleteByPKeyPartner();
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         
         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"deleteByPKeyPartner"); }
      }
   }

   /**
    * null
    */
   public void insertPartner (Partner toInsert) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"insertPartner"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerPersistence");
         context.startElement("insertPartner");
         if ( toInsert instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toInsert).marshal("toInsert", context, false);
         context.endElement("insertPartner");
         context.endElement("PartnerPersistence");
         logger.log(Level.FINER, context.toString());
      }

      try {
         delegate.insertPartner(toInsert);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerPersistence");
            context.startElement("insertPartner");
            if ( toInsert instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toInsert).marshal("toInsert", context, false);
            context.endElement("insertPartner");
            context.endElement("PartnerPersistence");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"insertPartner"); }
      }
   }

   /**
    * null
    */
   public void updatePartner (Partner toUpdate) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"updatePartner"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerPersistence");
         context.startElement("updatePartner");
         if ( toUpdate instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toUpdate).marshal("toUpdate", context, false);
         context.endElement("updatePartner");
         context.endElement("PartnerPersistence");
         logger.log(Level.FINER, context.toString());
      }

      try {
         delegate.updatePartner(toUpdate);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerPersistence");
            context.startElement("updatePartner");
            if ( toUpdate instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toUpdate).marshal("toUpdate", context, false);
            context.endElement("updatePartner");
            context.endElement("PartnerPersistence");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"updatePartner"); }
      }
   }

   /**
    * null
    */
   public void deletePartner (Partner toDelete) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"deletePartner"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerPersistence");
         context.startElement("deletePartner");
         if ( toDelete instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toDelete).marshal("toDelete", context, false);
         context.endElement("deletePartner");
         context.endElement("PartnerPersistence");
         logger.log(Level.FINER, context.toString());
      }

      try {
         delegate.deletePartner(toDelete);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerPersistence");
            context.startElement("deletePartner");
            if ( toDelete instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toDelete).marshal("toDelete", context, false);
            context.endElement("deletePartner");
            context.endElement("PartnerPersistence");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"deletePartner"); }
      }
   }

   /**
    * null
    */
   public void savePartner (Partner toSave) {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"savePartner"); }
      if ( logger.isLoggable(Level.FINER) ) {
         org.umlmda.runtime.xml.XMLMarshalContext context = 
            new org.umlmda.runtime.xml.XMLMarshalContext();
         
         context.startElement("PartnerPersistence");
         context.startElement("savePartner");
         if ( toSave instanceof org.umlmda.runtime.xml.XMLSerializable )
            ((org.umlmda.runtime.xml.XMLSerializable)toSave).marshal("toSave", context, false);
         context.endElement("savePartner");
         context.endElement("PartnerPersistence");
         logger.log(Level.FINER, context.toString());
      }

      try {
         delegate.savePartner(toSave);
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         if ( logger.isLoggable(Level.SEVERE) ) {
            org.umlmda.runtime.xml.XMLMarshalContext context = 
               new org.umlmda.runtime.xml.XMLMarshalContext();
            
            context.startElement("PartnerPersistence");
            context.startElement("savePartner");
            if ( toSave instanceof org.umlmda.runtime.xml.XMLSerializable )
               ((org.umlmda.runtime.xml.XMLSerializable)toSave).marshal("toSave", context, false);
            context.endElement("savePartner");
            context.endElement("PartnerPersistence");
            logger.log(Level.SEVERE, context.toString());
         }

         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"savePartner"); }
      }
   }

   public void onEjbCreate() throws javax.ejb.CreateException {
      PartnerFactory factory;

      factory = (PartnerFactory) getBeanFactory().getBean("PartnerFactory", PartnerFactory.class);
      if ( factory != null ) {
         setDelegate(factory.createPartnerPersistence());
      }
      else {
         String msg = "Unable to create an instance of "+PartnerFactory.class+" from bean factory";
         logger.log(Level.WARNING, msg);
         throw new javax.ejb.CreateException(msg);
      }
//@@UserSection-Begin PartnerPersistence.ejbCreate
//@@UserSection-End PartnerPersistence.ejbCreate      
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
   

//@@UserSection-Begin PartnerPersistence.NotModeledElements
//@@UserSection-End PartnerPersistence.NotModeledElements
};
